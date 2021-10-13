package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips");
		WebElement btn=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		Actions act=new Actions(driver);
		act.moveToElement(btn).perform();
		String toolTip=driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
		System.out.println(toolTip);
		Thread.sleep(2000);
		driver.close();
	}

}
