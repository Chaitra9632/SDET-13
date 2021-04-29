package com.crm.vtigerTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.graphbuilder.math.func.RandFunction;

public class CreateOrgWithIndustryTest {
	
	@Test
	public void createOrgWithIndustry() throws InterruptedException
	{
		WebDriverUtility wUtility=new WebDriverUtility();
		        //launch browser
				WebDriver driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//get URL
				driver.get("http://localhost:8888");
				
				//login to the application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Navigate to organizations
				driver.findElement(By.linkText("Organizations")).click();
				
				//create organization
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys("techM"+JavaUtility.getRandomData());
				
				//Select finance from industry drop-down
//				Select sel = new Select(driver.findElement(By.name("industry")));
//				sel.selectByVisibleText("Finance");
				WebElement industry=driver.findElement(By.name("industry"));
				wUtility.SelectOption(industry, "Finance");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(3000);
				//close browser
				driver.close();
				
				
				
				
	}
	
	

}
