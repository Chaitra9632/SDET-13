package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrgWithIndustryTest extends BaseClass {

	@Test
	public void createOrgWithIndustry() throws Throwable
	{
		
		String orgName=eUtil.getExcelData("Sheet1", 5, 2);
		String industryType=eUtil.getExcelData("Sheet1", 5, 3);
		
		

		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());

		//Select finance from industry drop-down
		//				Select sel = new Select(driver.findElement(By.name("industry")));
		//				sel.selectByVisibleText("Finance");
		WebElement industry=driver.findElement(By.name("industry"));
		wUtil.SelectOption(industry, industryType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		




	}



}
