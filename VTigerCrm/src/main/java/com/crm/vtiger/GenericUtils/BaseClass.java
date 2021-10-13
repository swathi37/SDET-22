package com.crm.vtiger.GenericUtils;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.pomrepositorylib.Home;
	import com.vtiger.pomrepositorylib.Login;

	/**
	 * This class contains basic configuration annotation
	 * @author USER
	 *
	 */
	public class BaseClass {
		
		public FileUtility flib=new FileUtility();
		public ExcelUtility elib=new ExcelUtility();
		public WebDriverUtility wlib=new WebDriverUtility();
		public JavaUtility jlib=new JavaUtility();
		public WebDriver driver;
		public static WebDriver sDriver;
		@BeforeSuite
		public void connectDB()
	    {
			System.out.println("===Connection successful===");
		}
		@Parameters(value= {"browser"})
		@BeforeClass
		public void launchBrowser(String browserValue) throws Throwable
		{
			//System.setProperty("webdriver.chrome.driver","./Driver/chromedriver94.exe");
			//Read a data from property file
			//String browser = flib.getPropertyKeyValue("browser");
			String url = flib.getPropertyKeyValue("url");
			if(browserValue.equalsIgnoreCase("Chrome"))
			{
				
				driver=new ChromeDriver();
				
			}
			else if(browserValue.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			
			else
			{
				System.out.println("Invalid browser name");
			}
			
			System.out.println("===Browser launch successful===");
			wlib.maximiseWindow(driver);
			wlib.waitUntilPageLoad(driver);
			driver.get(url);	
			sDriver=driver;
			
		}
		@BeforeMethod(groups= {"smokeTest"})
		public void loginToApp() throws Throwable
		{
			//read a data from property file
			String username = flib.getPropertyKeyValue("username");
			String password = flib.getPropertyKeyValue("password");
			Login lg=new Login(driver);
			lg.loginToApp(username, password);
			System.out.println("===Login sucessful===");
		}
		@AfterMethod(groups= {"smokeTest"})
		public void logoutOfApp()
		{
			Home h=new Home(driver);
			h.logout();
			System.out.println("===Logout Successful===");
		}
		@AfterClass(groups= {"smokeTest"})
		public void closeBrowser()
		{
			driver.close();
			System.out.println("====Browser closed successfil=====");
		}
		@AfterSuite(groups= {"smokeTest"})
		public void closeDB()
		{
			System.out.println("====DB connection closed====");
		}

	}



