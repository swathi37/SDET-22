package com.crm.vtiger.GenericUtils;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * author @ swathi
	 */
	/**
	 * this method is generate random to avoid duplicate
	 * @return
	 */
	public static String getRandomData()
	{
		Random random = new Random(); 
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * this method is used to generate currentdate
	 * @return
	 */
	public static String getCurrentDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}

}