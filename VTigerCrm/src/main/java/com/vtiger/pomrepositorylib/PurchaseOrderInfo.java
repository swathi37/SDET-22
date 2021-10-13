package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfo {

	public PurchaseOrderInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successMsg;
	
	@FindBy(xpath="(//input[@title='Delete [Alt+D]'])")
	private WebElement deleteBtn;
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	

}
