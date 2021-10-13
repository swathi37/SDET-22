package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImpl implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("====Listening====");
		EventFiringWebDriver takescreenshot=new EventFiringWebDriver(BaseClass.sDriver);
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		Date d =new Date();
		String date = d.toString().replaceAll(":","_").replaceAll(" ", "_");
		File dest=new File("./screenshot/"+testName+date+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	

}

