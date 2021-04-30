package com.crm.SDET_13;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;

public class GetData {
	
	@Test
	public void getData() throws Throwable {
		ExcelUtility e=new ExcelUtility();
		String value=e.getExcelData("Sheet1", "TC_02", "lastName");
		System.out.println(value);
	}

}
