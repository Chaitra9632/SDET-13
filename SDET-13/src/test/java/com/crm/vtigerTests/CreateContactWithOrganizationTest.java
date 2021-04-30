package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactWithOrganizationTest {

	@Test
	public void createContactWithOrg() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", 3, 2);
		String lastName=eUtil.getExcelData("Sheet1", 3, 3);
		FileUtility fUtil=new FileUtility();
		String browserName=fUtil.getPropertyKeyValue("browser");
		String url=fUtil.getPropertyKeyValue("url");
		String username=fUtil.getPropertyKeyValue("username");
		String password=fUtil.getPropertyKeyValue("password");
		
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=null;
		//launch browser
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//get URL
		driver.get(url);

		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		//Set<String> window = driver.getWindowHandles();
		//				Iterator<String> iterator= window.iterator();
		//				while(iterator.hasNext())
		//				{
		//					String winId=iterator.next();
		//					driver.switchTo().window(winId);
		//					System.out.println(driver.getTitle());
		//				}
		
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.close();
	}

}
