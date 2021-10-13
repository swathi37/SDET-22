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

public class TC_09CreatePurchaseOrderAndDelete extends BaseClass {
	
	@Test(groups= {"smokeTest"})
	public void CreatePurchaseOrderAndDelete() throws Throwable
	{
		    String productName = elib.getExcelData("sheet1", 9, 5);
		    String vendorName = elib.getExcelData("sheet1", 9, 4);
		    String subject = elib.getExcelData("sheet1", 9, 1);
		    String billingAdd=elib.getExcelData("sheet1", 9, 2);
		    String quantity = elib.getExcelData("sheet1", 9, 3);
		    
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
		    npo.createPurchaseOrderAndDelete(subject,vendorName,billingAdd,productName,quantity);
		   
		    
		    
		    
		   
		    
	}

}
