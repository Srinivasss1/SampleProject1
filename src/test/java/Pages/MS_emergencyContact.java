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

public class MS_emergencyContact {
	WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
		
	public void emergencycontact(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReports extent)
		{
			this.driver = driver;
			this.logger=logger;
			this.extent=extent;
			this.TestScriptName=TestScriptName;
		}
		

	public  void contact_details(String name,String relationship,String mobile1) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	findElement(By.id("menu_pim_viewPimModule")).click();
	//	findElement(By.id("menu_pim_viewEmployeeList")).click();
	//	findElement(By.linkText("0272")).click();
		findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();
		findElement(By.xpath("//input[@id='btnAddContact']")).click();
		findElement(By.id("emgcontacts_name")).sendKeys(name);
		findElement(By.id("emgcontacts_relationship")).sendKeys(relationship);
		findElement(By.id("emgcontacts_mobilePhone")).sendKeys(mobile1);
		
					
		/*Select dropdown = new Select(driver.findElement(By.id("contact_country")));
			dropdown.selectByVisibleText("India");*/
			
		findElement(By.id("btnSaveEContact"));
		
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("MS_emergencyContact - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		WebElement element =findElement(By.id("btnSaveEContact"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
		
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
