package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Extent_Reports.ExtentReport;

public class MS_contactdetails {

	WebDriver driver;
	
		ExtentTest logger;
		ExtentReports extent;
		String screenShotPath;
		String TestScriptName;
			
		public void contactdetails(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReports extent)
			{
				this.driver = driver;
				this.logger=logger;
				this.extent=extent;
				this.TestScriptName=TestScriptName;
			}
			

		public  void Addpersonaldetails(String adress,String city,String state) throws Exception
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//	findElement(By.id("menu_pim_viewPimModule")).click();
		//	findElement(By.id("menu_pim_viewEmployeeList")).click();
		//	findElement(By.linkText("0272")).click();
			findElement(By.xpath("//a[contains(text(),'Contact Details')]")).click();
			findElement(By.xpath("//input[@id='btnSave']")).click();
			findElement(By.id("contact_street1")).sendKeys(adress);
			findElement(By.id("contact_city")).sendKeys(city);
			findElement(By.id("contact_province")).sendKeys(state);
			
			Thread.sleep(15000);
					
	Select dropdown = new Select(driver.findElement(By.id("contact_country")));
				dropdown.selectByValue("IN");
				
				
			findElement(By.id("btnSave"));
		
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("MS_contactdetails - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			findElement(By.id("btnSave")).click();
			
		}
		
		
		public   WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}
		



}
