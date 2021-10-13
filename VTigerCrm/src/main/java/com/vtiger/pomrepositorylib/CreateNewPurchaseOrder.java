package com.vtiger.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewPurchaseOrder extends WebDriverUtility {
	WebDriver driver;
	public CreateNewPurchaseOrder(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement vendorNameIcon;
	
	@FindBy(name="bill_street")
	private WebElement billingAddEdt;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingAddBtn;
	
	@FindBy()
	private WebElement itemEdt;
	
	@FindBy(id="searchIcon1")
	private WebElement itemImg;
	
	@FindBy(id="qty1")
	private WebElement qty;
	
	@FindBy(id="qty2")
	private WebElement qtyAddPro;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement addProduct;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[2]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@id='searchIcon2']")
	private WebElement addProductIcon;


	public WebElement getSubjectEdt() {
		return subjectEdt;
	}


	public WebElement getVendorNameIcon() {
		return vendorNameIcon;
	}


	public WebElement getBillingAddEdt() {
		return billingAddEdt;
	}


	public WebElement getCopyBillingAddBtn() {
		return copyBillingAddBtn;
	}


	public WebElement getItemImg() {
		return itemImg;
	}


	public WebElement getQty() {
		return qty;
	}


	public WebElement getAddProduct() {
		return addProduct;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getAddProductIcon() {
		return addProductIcon;
	}
	
	public void createNewPerchaseOrder(String subject, String vname, String billingAdd,String pname,String quantity) throws Throwable
	{
		subjectEdt.sendKeys(subject);
		vendorNameIcon.click();
		
		switchToWindow(driver,"Vendors&action");
		Vendors v=new Vendors(driver);
		v.getSearchEdt().sendKeys(vname);
		v.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitAndClick(billingAddEdt);
		billingAddEdt.sendKeys(billingAdd);
		copyBillingAddBtn.click();
		scrollToWebElement(driver, itemImg);
		itemImg.click();
		switchToWindow(driver,"Products&action");
		Products pro=new Products(driver);
		pro.getSearchEdt().sendKeys(pname);
		pro.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitAndClick(qty);
		qty.sendKeys(quantity);
		saveBtn.click();
		
		
		
		
	}
	
	public void createNewPerchaseOrderWithVendor(String subject,String vname,String billingAdd,String Quantity) throws Throwable
	{
		subjectEdt.sendKeys(subject);
		vendorNameIcon.click();
		
		switchToWindow(driver,"Vendors&action");
		Vendors v=new Vendors(driver);
		v.getSearchEdt().sendKeys(vname);
		v.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		billingAddEdt.sendKeys(billingAdd);
		copyBillingAddBtn.click();
		saveBtn.click();
		acceptAlert(driver);
		
		
		
	}
	public void createPerchaseOrderwithItem(String subject,String pname,String billingAdd,String quantity) throws Throwable
	{
		subjectEdt.sendKeys(subject);
		billingAddEdt.sendKeys(billingAdd);
		copyBillingAddBtn.click();
		scrollToWebElement(driver, itemImg);
		itemImg.click();
		switchToWindow(driver,"Products&action");
		Products pro=new Products(driver);
		pro.getSearchEdt().sendKeys(pname);
		pro.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		Thread.sleep(1000);
		qty.sendKeys(quantity);
		saveBtn.click();
		acceptAlert(driver);
	}
	
	public void PerchaseOrderAddProduct(String subject, String vname,String billingAdd,String pname,String quantity) throws Throwable
	{
		subjectEdt.sendKeys(subject);
		vendorNameIcon.click();
		
		switchToWindow(driver,"Vendors&action");
		Vendors v=new Vendors(driver);
		v.getSearchEdt().sendKeys(vname);
		v.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vname+"']")).click();
		Thread.sleep(2000);
		switchToWindow(driver,"PurchaseOrder&action");
		
		billingAddEdt.sendKeys(billingAdd);
		copyBillingAddBtn.click();
		scrollToWebElement(driver, itemImg);
		itemImg.click();
		switchToWindow(driver,"Products&action");
		Products pro=new Products(driver);
		pro.getSearchEdt().sendKeys(pname);
		pro.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitForElementVisiblity(driver,qty);
		qty.sendKeys(quantity);
		addProduct.click();
		addProductIcon.click();
		switchToWindow(driver,"Products&action");
		Thread.sleep(2000);
		pro.getSearchEdt().sendKeys(pname);
		pro.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitForElementVisiblity(driver,qtyAddPro);
		qtyAddPro.sendKeys(quantity);
		saveBtn.click();
		acceptAlert(driver);
		
		
		
	}
	public void createPurchaseOrderAndDelete(String subject, String vname, String billingAdd,String pname,String quantity) throws Throwable
	{
		subjectEdt.sendKeys(subject);
		vendorNameIcon.click();
		
		switchToWindow(driver,"Vendors&action");
		Vendors v=new Vendors(driver);
		v.getSearchEdt().sendKeys(vname);
		v.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitForElementVisiblity(driver,billingAddEdt);
		billingAddEdt.sendKeys(billingAdd);
		copyBillingAddBtn.click();
		scrollToWebElement(driver, itemImg);
		itemImg.click();
		switchToWindow(driver,"Products&action");
		Products pro=new Products(driver);
		pro.getSearchEdt().sendKeys(pname);
		pro.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		switchToWindow(driver,"PurchaseOrder&action");
		waitForElementVisiblity(driver,qty);
		qty.sendKeys(quantity);
		saveBtn.click();
		PurchaseOrderInfo pi=new PurchaseOrderInfo(driver);
	    pi.getDeleteBtn().click();
	    acceptAlert(driver);
	
	}


	public WebElement getQtyAddPro() {
		return qtyAddPro;
	}


	
	
	
	
}
