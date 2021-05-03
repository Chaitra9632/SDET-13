package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass{
	
	@Test
	public void createOrganization() throws Throwable
	{
		String orgName=eUtil.getExcelData("Sheet1", 1, 2);
		
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("organization page found",true);
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("click on create organization");
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		Reporter.log("create organization with organization name");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("click on save");
		
	    //verification
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    //Assert.assertTrue(expData.contains(orgName));
	    SoftAssert asrt = new SoftAssert();
	    asrt.assertTrue(expData.contains(orgName));
	    System.out.println(expData);
	    
	    Reporter.log("the expected data is"+expData , true);
	    
	    
		
	}

}
