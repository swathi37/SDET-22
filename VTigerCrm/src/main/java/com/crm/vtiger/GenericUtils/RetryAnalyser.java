package com.crm.vtiger.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int counter=0;
	int retrylimit=4;

	public boolean retry(ITestResult result) {
		while(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}
}