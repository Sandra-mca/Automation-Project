package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.Page_Class;


public class Test_Class {
	WebDriver driver;
	  @BeforeTest
	  public void bt()
	  {
		  driver=new ChromeDriver();
		  ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
	  }
		    
	  
	  
	  
	  
	  @BeforeMethod
	  public void bm()
	  {
		  driver.get("https://www.air.irctc.co.in/");
		  driver.manage().window().maximize();
	  }
	  
	  
	  
	  
	  @Test
	  public void test() throws Exception
	  {
		  Page_Class ob=new Page_Class(driver);
		  ob.mousehover();
		  ob.testverification();
		   ob.contentverification();
		   ob.logoverification();
		   ob.search();
		   ob.screenshot_Full();
		   ob.Screenshot_Single_Element();
		   ob.scrolldown();
		   ob.windowhandling();
		   ob.linkvalidation();
		   ob.login();
		   driver.quit();
		  
		 
		 
		 
	  }
}
