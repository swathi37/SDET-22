package com.crm.vtiger.GenericUtils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/*
	 * author @ swathi
	 */
	/*
	 * This method wait for 20 sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/*
	 *This method wait for the element to be visible
	 *@param driver
	 *@param element 
	 */
	public void waitForElementVisiblity(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method wait for element to be clicked
	 * @param element
	 * @throws Throwable 
	 * 
	 * 
	 */
	public void waitAndClick(WebElement element) throws Throwable 
	{
		int count=0;
		while(count<40)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable e){
				Thread.sleep(1000);
				count++;
				
			}
			
		}
	}
	/**
	 * this methods enables user to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element,String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * this methods enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void SeletOption(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method will perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method performs right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	} 
	/**
	 * This method helps to switch from one window to another 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();	
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * Accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method used for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	public String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable
	{
		String screenshotPath="./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);
	    Files.copy(src, dest);
	    return screenshotPath;
	}
	
	public void pressEnterKey() throws Throwable
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	

}
