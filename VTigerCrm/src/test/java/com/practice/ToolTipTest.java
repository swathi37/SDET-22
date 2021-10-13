package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ToolTipTest {
	@Test
	public void toolTip() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips");
		WebElement btn=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.mouseOver(driver, btn);
		String toolTip=driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
		driver.findElement(By.xpath(" //input[@id='toolTipTextField']")).sendKeys(toolTip);
		Thread.sleep(5000);
		driver.close();
	}

}
