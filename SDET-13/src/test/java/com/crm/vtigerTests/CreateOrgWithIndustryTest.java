package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrgWithIndustryTest {

	@Test
	public void createOrgWithIndustry() throws Throwable
	{
		FileUtility fUtil=new FileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", 5, 2);
		String industryType=eUtil.getExcelData("Sheet1", 5, 3);
		
		String browserName=fUtil.getPropertyKeyValue("browser");
		WebDriver driver=null;
		WebDriverUtility wUtility=new WebDriverUtility();
		if(browserName.equalsIgnoreCase("firefox")) {
			//launch browser
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//get URL
		driver.get(fUtil.getPropertyKeyValue("url"));

		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(fUtil.getPropertyKeyValue("username"));
		driver.findElement(By.name("user_password")).sendKeys(fUtil.getPropertyKeyValue("password"));
		driver.findElement(By.id("submitButton")).click();

		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());

		//Select finance from industry drop-down
		//				Select sel = new Select(driver.findElement(By.name("industry")));
		//				sel.selectByVisibleText("Finance");
		WebElement industry=driver.findElement(By.name("industry"));
		wUtility.SelectOption(industry, industryType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		//close browser
		driver.close();




	}



}
