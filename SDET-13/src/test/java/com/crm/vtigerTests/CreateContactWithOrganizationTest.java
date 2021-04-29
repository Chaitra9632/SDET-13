package com.crm.vtigerTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactWithOrganizationTest {
	
	@Test
	public void createContactWithOrg()
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		 
		//launch browser
				WebDriver driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				//get URL
				driver.get("http://localhost:8888");
				
				//login to the application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Navigate to contacts
				driver.findElement(By.linkText("Contacts")).click();
				
				//Create Contact with organization
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys("Chaitra");
				
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
				//Set<String> window = driver.getWindowHandles();
//				Iterator<String> iterator= window.iterator();
//				while(iterator.hasNext())
//				{
//					String winId=iterator.next();
//					driver.switchTo().window(winId);
//					System.out.println(driver.getTitle());
//				}
				String orgName="SkillRary381";
				wUtil.switchToWindow(driver, "Accounts");
				driver.findElement(By.id("search_txt")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(orgName)).click();
				wUtil.switchToWindow(driver, "Contacts");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
