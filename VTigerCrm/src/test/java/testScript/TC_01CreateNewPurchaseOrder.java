package testScript;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewProducts;
import com.vtiger.pomrepositorylib.CreateNewPurchaseOrder;
import com.vtiger.pomrepositorylib.CreateVendor;
import com.vtiger.pomrepositorylib.Home;
import com.vtiger.pomrepositorylib.Products;
import com.vtiger.pomrepositorylib.PurchaseOrder;
import com.vtiger.pomrepositorylib.PurchaseOrderInfo;
import com.vtiger.pomrepositorylib.Vendors;
//@Listeners(com.crm.vtiger.GenericUtils.ListnerImpl.class)
public class TC_01CreateNewPurchaseOrder extends BaseClass {
	
	@Test
	public void createPurchaseOrder() throws Throwable
	{
		String productName = elib.getExcelData("sheet1", 1, 5);
		String vendorName = elib.getExcelData("sheet1", 1, 4);
		String subject = elib.getExcelData("sheet1", 1, 1);
		String billingAdd=elib.getExcelData("sheet1", 1, 2);
		String quantity = elib.getExcelData("sheet1", 1, 3);
		
		Home h=new Home(driver);
	    h.getProductLink().click();
	    
	    Products p=new Products(driver);
	    p.getCreateProductImg().click();
	   
	    
	    CreateNewProducts np=new CreateNewProducts(driver);
	    np.createProduct(productName);
	    h.more();
	    h.getVendorLink().click();
	    Vendors v=new Vendors(driver);
	    v.getCreateVendorImg().click();
	    CreateVendor cv=new CreateVendor(driver);
	    cv.createNewVendor(vendorName);
	    
	    h.more();
	    h.getPurchaseorderLink().click();
	    PurchaseOrder po=new PurchaseOrder(driver);
	    po.getCreatePurchaseOrderImg().click();
	    CreateNewPurchaseOrder npo=new CreateNewPurchaseOrder(driver);
	    npo.createNewPerchaseOrder(subject,vendorName,billingAdd,productName,quantity);
	    npo.getSaveBtn().click();
	    PurchaseOrderInfo pi=new PurchaseOrderInfo(driver);
	    wlib.waitForElementVisiblity(driver, pi.getSuccessMsg());
	    String actualMsg=pi.getSuccessMsg().getText();
	    Assert.assertTrue(actualMsg.contains(productName));
	    System.out.println("Purchase Order created successfully");
	    
	}


}
