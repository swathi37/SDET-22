package testScript;


import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewProducts;
import com.vtiger.pomrepositorylib.CreateNewPurchaseOrder;
import com.vtiger.pomrepositorylib.CreateVendor;
import com.vtiger.pomrepositorylib.Home;
import com.vtiger.pomrepositorylib.Products;
import com.vtiger.pomrepositorylib.PurchaseOrder;

import com.vtiger.pomrepositorylib.Vendors;

public class TC_05CreatePurchaseOrderWithAddProduct extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void createPurchaseOrderWithAddProduct() throws Throwable
	{
		String productName = elib.getExcelData("sheet1", 7, 5);
		String vendorName = elib.getExcelData("sheet1", 7, 4);
		String subject = elib.getExcelData("sheet1", 7, 1);
	    String billingAdd=elib.getExcelData("sheet1", 7, 2);
	    String quantity = elib.getExcelData("sheet1", 7, 3);
	    
	    Home h=new Home(driver);
	    h.getProductLink().click();
	    
	    Products p=new Products(driver);
	    p.getCreateProductImg().click();
	    
	    CreateNewProducts np=new CreateNewProducts(driver);
        np.createProduct(productName);
	    
	    //create vendor
	    h.more();
	    h.getVendorLink().click();
	    Vendors v=new Vendors(driver);
	    v.getCreateVendorImg().click();
	    CreateVendor cv=new CreateVendor(driver);
        cv.createNewVendor(vendorName);
	    
	    //create purchase order
	    h.more();
	    h.getPurchaseorderLink().click();
	    PurchaseOrder po=new PurchaseOrder(driver);
	    po.getCreatePurchaseOrderImg().click();;
	    CreateNewPurchaseOrder npo=new CreateNewPurchaseOrder(driver);
        npo.PerchaseOrderAddProduct(subject,vendorName,billingAdd,productName,quantity);
	    
	    /*PurchaseOrderInfo pi=new PurchaseOrderInfo(driver);
	    wlib.waitForElementVisiblity(driver, pi.getSuccessMsg());
    String actualMsg=pi.getSuccessMsg().getText();
	    Assert.assertTrue(actualMsg.contains(productName));
	    System.out.println("Purchase Order created successfully");*/
	}

}
