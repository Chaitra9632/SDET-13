package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass{
	
	@Test
	public void createOrganization() throws Throwable
	{
		String orgName=eUtil.getExcelData("Sheet1", 1, 2);
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		
	}

}
