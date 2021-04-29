package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * @Chaitra
 */

public class JavaUtility {
	
	/**
	 * generate random number 
	 * @Chaitra
	 * 
	 */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;			
	}
	
	/**
	 * Generate current system date
	 * @Chaitra
	 */
	public String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentDate=date.toString();
		return currentDate;
		
	}
	

}
