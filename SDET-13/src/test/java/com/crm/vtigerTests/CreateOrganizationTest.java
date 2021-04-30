package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest {
	
	JavaUtility ju=new JavaUtility();
	
	@Test
	public void createOrganization() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", 1, 2);
		
		FileUtility fUtil=new FileUtility();
		String browserName=fUtil.getDataFromJson("browser");
		String url=fUtil.getDataFromJson("url");
		String username=fUtil.getDataFromJson("username");
		String password=fUtil.getDataFromJson("password");
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("firefox")) {
		//launch browser
		driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser Name!!!");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//get URL
		driver.get(url);
		
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	    //Close Browser
		driver.close();
		
	}

}
