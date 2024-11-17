package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Class {
	
	
	
	WebDriver driver;
	
	
	public Page_Class(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void testverification()
	{
		System.out.println(driver.getTitle());
		String actual=driver.getTitle();
		String expected="Best Domestic & International Flight Booking Website";
		if(actual.equals(expected))
		{
			System.out.println("Title verification is Pass");
		}
		else
		{
			System.out.println("Title verification is Fail");
		}
	}
	
	
	
	public void contentverification()
	{
		String content=driver.getPageSource();
		if(content.contains("Login"))
		{
			System.out.println("Content verification is Pass");
		}
		else
		{
			System.out.println("Content verification is Fail");
		}
	}
	
	
	
	
	public void linkvalidation()
	{
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		for(WebElement l:link)
		{
			String li=l.getAttribute("href");
			verify(li);
		}
	
	}
	private void verify(String li) {
		try {
			
			URL obj=new URL(li);
			HttpURLConnection con=(HttpURLConnection)obj.openConnection();
			int code=con.getResponseCode();
			if(con.getResponseCode()==200)
			{
				System.out.println("valid----------------------+"+li);
			}		
			else
			{
				{
					System.out.println("Not valid----------------------+"+li);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void logoverification()
	{
		WebElement logo = driver.findElement(By.xpath("/html/body/app-root/app-header/header/nav/div/div[3]/div/div/a/img"));
		boolean l=logo.isDisplayed();
		if(l) {
			System.out.println("Logo is displayd in the site");
		}
		else
		{
			System.out.println("Logo is not displayed");
		}
	}
	
	public void mousehover()
	{
		WebElement electronics=driver.findElement(By.xpath("//*[@id=\"dropdown10\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(electronics).perform();
	}
	
	
	public void screenshot_Full() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("F://project.png"));
	}
	
	
	public void Screenshot_Single_Element() throws IOException
	{
		WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-header/header/nav/div/div[1]/a/img"));
		File sc=element.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sc,new File("./Screenshot//Pojectimg.png"));
	}
	
	public void scrolldown() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
			}
	
	public void search()
	
		{
		
		driver.findElement(By.xpath("//*[@id=\"student\"]")).click();
		driver.findElement(By.xpath("//*[@id='stationFrom']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Bengaluru (BLR)')]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"stationTo\"]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Chennai (MAA)')])[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[1]/table/tr[2]/td/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/span")).click();

		driver.findElement(By.xpath("//*[@id=\"noOfpaxEtc\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/div/div/a[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[6]/button")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modalCustomLoader")));

		    // Attempt to click the image after the overlay is gone
		    WebElement imgElement = driver.findElement(By.xpath("/html/body/app-root/app-header/header/nav/div/div[1]/a/img"));

		    // Use JavaScript click as a fallback if the regular click doesn't work
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", imgElement);
			
		}
	
	
	
	
	
     public void login() throws Exception

	{
		
		driver.findElement(By.xpath("/html/body/app-root/app-header/header/nav/div/div[3]/div/ul/li[3]/a")).click();
		WebElement passwordField = driver.findElement(By.xpath("(//input[@name=\"password\"])[1]"));

		// Check if password field is enabled
		boolean isEnabled = passwordField.isEnabled();
		System.out.println("Is password field enabled? " + isEnabled);

		// Check if password field is editable
		boolean isEditable = !passwordField.getAttribute("readonly").equals("true") && !passwordField.getAttribute("disabled").equals("true");
		System.out.println("Is password field editable? " + isEditable);

		File f=new File("F:\\new.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username="+username);
			
			
			String password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password="+password);
			
			 
			
			driver.findElement(By.xpath("//*[@id=\"loginuseridUser\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"loginuseridUser\"]")).sendKeys(username);  
			
			
			  ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + password + "';", passwordField);

			    WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Login')])[5]"));
			    element.click();

			    // Add delay or explicit wait to handle login process
			    Thread.sleep(2000);
			    
			  
			}
			
	}

	public void windowhandling() {
		String parentwindow=driver.getWindowHandle();
		System.out.println("Parent Window Title : "+ driver.getTitle());
		
		
		
		  WebElement li = driver.findElement(By.xpath("(//*[contains(text(),'Hotels')])[1]"));

		    // Use explicit wait before clicking
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(li));

		    // Click using JavaScript to avoid interception issues
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", li);
		    
		    
		    
		    
		Set<String> allwindows = driver.getWindowHandles();
		for(String handle:allwindows)
		{
			System.out.println(handle);
			
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				
				System.out.println("Child Window Title : "+driver.getTitle());
				driver.close();
			}
			
			driver.switchTo().window(parentwindow);
		}
		
		
	}
	
	
	

	
	
}


