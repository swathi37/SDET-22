package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProducts {
	public CreateNewProducts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSave() {
		return save;
	}
	public void createProduct(String pName)
	{
		productName.sendKeys(pName);
		save.click();
	}

}
