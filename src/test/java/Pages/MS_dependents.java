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

public class MS_dependents {
	WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
		
	public void dependents(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReports extent)
		{
			this.driver = driver;
			this.logger=logger;
			this.extent=extent;
			this.TestScriptName=TestScriptName;
		}
		

	public  void dependent_details(String dependent_name) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	findElement(By.id("menu_pim_viewPimModule")).click();
	//	findElement(By.id("menu_pim_viewEmployeeList")).click();
	//	findElement(By.linkText("0272")).click();
		findElement(By.xpath("//a[contains(text(),'Dependents')]")).click();
		findElement(By.xpath("//input[@id='btnAddDependent']")).click();
		findElement(By.id("dependent_name")).sendKeys(dependent_name);
		
						
		Select dropdown = new Select(driver.findElement(By.id("dependent_relationshipType")));
			dropdown.selectByVisibleText("Child");
			
		findElement(By.id("btnSaveDependent"));
		
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("MS_dependents - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("btnSaveDependent")).click();
		
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
