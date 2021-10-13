package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewProducts;
import com.vtiger.pomrepositorylib.CreateNewPurchaseOrder;
import com.vtiger.pomrepositorylib.Home;
import com.vtiger.pomrepositorylib.Products;
import com.vtiger.pomrepositorylib.PurchaseOrder;
import com.vtiger.pomrepositorylib.PurchaseOrderInfo;

public class TC_04CreatePurchaseOrderWithItem extends BaseClass{
	
	@Test(groups= {"smokeTest"})
	public void createPurchaseOrderWithItem() throws Throwable
	{
		String productName = elib.getExcelData("sheet1", 5, 4);
		String subject = elib.getExcelData("sheet1", 5, 1);
	    String billingAdd=elib.getExcelData("sheet1", 5, 2);
	    String quantity = elib.getExcelData("sheet1", 5, 3);
	    
	    Home h=new Home(driver);
	    h.getProductLink().click();
	    Products p=new Products(driver);
	    p.getCreateProductImg().click();
	    CreateNewProducts np=new CreateNewProducts(driver);
	    
	    np.createProduct(productName);
	    
	    h.more();
	    h.getPurchaseorderLink().click();
	    PurchaseOrder po=new PurchaseOrder(driver);
	    po.getCreatePurchaseOrderImg().click();
	    CreateNewPurchaseOrder npo=new CreateNewPurchaseOrder(driver);
	    
	    npo.createPerchaseOrderwithItem(subject, productName, billingAdd, quantity);
	    
	    PurchaseOrderInfo pi=new PurchaseOrderInfo(driver);
	    wlib.waitForElementVisiblity(driver, pi.getSuccessMsg());
	    String actualMsg=pi.getSuccessMsg().getText();
	    Assert.assertFalse(actualMsg.contains(productName));
	    System.out.println("Purchase Order created successfully");
	}

}
