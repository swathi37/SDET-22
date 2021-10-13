package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewPurchaseOrder;
import com.vtiger.pomrepositorylib.CreateVendor;
import com.vtiger.pomrepositorylib.Home;

import com.vtiger.pomrepositorylib.PurchaseOrder;
import com.vtiger.pomrepositorylib.PurchaseOrderInfo;
import com.vtiger.pomrepositorylib.VendorInfo;
import com.vtiger.pomrepositorylib.Vendors;

public class TC_02CreatePurchseOrderWithVendorName extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void createPurchseOrderWithVendorName() throws Throwable
	{
		String vendorName = elib.getExcelData("sheet1", 3, 4);
		String subject = elib.getExcelData("sheet1", 3, 1);
	    String billingAdd=elib.getExcelData("sheet1", 3, 2);
	    String quantity = elib.getExcelData("sheet1", 3, 3);
	    String productName=elib.getExcelData("sheet1", 3, 5);
	    
	    
	    
	    //create vendor
	    Home h=new Home(driver);
	    h.more();
	    h.getVendorLink().click();
	    //navigate to vendor
	    Vendors v=new Vendors(driver);
	    v.getCreateVendorImg().click();
	    //navigate to create vendor 
	    CreateVendor cv=new CreateVendor(driver);
	   
	    cv.createNewVendor(vendorName);
	    VendorInfo vi=new VendorInfo(driver);
	    wlib.waitForElementVisiblity(driver, vi.getSuccessMsg());
	    String vendorSucMsg = vi.getSuccessMsg().getText();
	    if(vendorSucMsg.contains(vendorName))
	    {
	    	System.out.println("New vendor Created -> Test pass");
	    }
	    else
	    {
	    	System.out.println("New vendor not created-> test failed");
	    }
	    
	    h.more();
	    h.getPurchaseorderLink().click();
	    
	    //navigate to purchase order
	    PurchaseOrder po=new PurchaseOrder(driver);
	    po.getCreatePurchaseOrderImg().click();
	    
	    //navigate to new purchase order
	    CreateNewPurchaseOrder npo=new CreateNewPurchaseOrder(driver);
	    npo.createNewPerchaseOrderWithVendor(subject, vendorName, billingAdd, quantity);
	    PurchaseOrderInfo pi=new PurchaseOrderInfo(driver);
	    wlib.waitForElementVisiblity(driver, pi.getSuccessMsg());
	    String actualMsg=pi.getSuccessMsg().getText();
	   Assert.assertFalse(actualMsg.contains(productName));
	    System.out.println("Purchase Order created successfully");
	}

}
