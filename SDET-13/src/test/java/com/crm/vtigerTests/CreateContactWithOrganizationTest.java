package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test
	public void createContactWithOrg() throws Throwable
	{
		String orgName=eUtil.getExcelData("Sheet1", "TC_02", "organizationName");
		String lastName=eUtil.getExcelData("Sheet1", "TC_02", "lastName");
		//Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
