package com.crm.SDET_13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CaptureDynamicWebTable {
	
	@Test
	public void captureOrgName()
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Step 1: get url
		driver.get("http://localhost:8888");
		
		//Step 2: login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to organizations
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Organizations")).click();
		String expData="Skillrary381";
		//Boolean flag=false;
		int actRowCount=0;
		
		
		//Step 4: capture all the organization names
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
		List<WebElement> list = driver.findElements(By.xpath(x));
		
		for(WebElement wb:list)
		{
			String actData=wb.getText();
			if(expData.equals(actData))
			{
				//wb.click();
				//flag=true;
				break;
			}
			actRowCount++;
		}
		System.out.println(actRowCount);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+actRowCount+"]/td[8]/a[.='del']")).click();
		
		
	   
	  
	}

}
