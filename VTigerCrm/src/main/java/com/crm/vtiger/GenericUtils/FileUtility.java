package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	/**
	 * author @ swathi
	 */
	/**
	 * This method used to read data from properties and return the value based on key specified
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties pro=new Properties();
		pro.load(file);
		return pro.getProperty(key);
	}

}
