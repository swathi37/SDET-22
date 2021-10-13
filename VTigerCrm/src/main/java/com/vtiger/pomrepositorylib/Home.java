package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Home  {
	
	
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement singoutLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseorderLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	
	@FindBy(name="Organizations")
	private WebElement organizationLink;
	
	

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSingoutLink() {
		return singoutLink;
	}

	public WebElement getPurchaseorderLink() {
		return purchaseorderLink;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}
	
	public void logout()
	{
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.mouseOver(driver, administratorImg);
		singoutLink.click();
		
	}
	public void more()
	{
		WebDriverUtility wutil=new WebDriverUtility();
				wutil.mouseOver(driver, moreLink);
				
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	

}
