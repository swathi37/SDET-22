package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendor {
	public CreateVendor(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorname;
	 
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save;

	public WebElement getVendorname() {
		return vendorname;
	}

	public WebElement getSave() {
		return save;
	} 
	
	public void createNewVendor(String vendorName)
	{
		vendorname.sendKeys(vendorName);
		save.click();
	}
	
	

}
