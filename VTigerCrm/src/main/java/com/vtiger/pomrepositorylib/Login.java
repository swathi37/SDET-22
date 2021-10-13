package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Login extends WebDriverUtility 
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//actions to be performed on login page
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}

}
