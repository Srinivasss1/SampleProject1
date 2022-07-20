package Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.*;

import Extent_Reports.ExtentReport;

public class MS_homepage {
	//declare local variables for classes, so we can use in method levels
	
	WebDriver driver;
	ExtentTest logger;
	ExtentReporter extent;
	String screenShotPath;
	String TestScriptName;
	
//create object for above local variables so that we can pass this class pages to main test case
//declare local variables at method level and create objects for variables
public MS_homepage(WebDriver driver,ExtentReporter extent, String TestScriptName,String ScreenShotPath,ExtentTest logger ) {
	
	this.driver = driver;
	this.logger = logger;
	this.extent = extent;  
	this.TestScriptName = TestScriptName;
	this.screenShotPath = ScreenShotPath;
}

public void logout() throws Exception
{	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		findElement(By.id("welcome")).click();
		
		screenShotPath=ExtentReport.capture(driver,TestScriptName);
		logger.pass("HomePage - Logout Page",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.linkText("Logout")).click();
}
	
	public WebElement findElement(By by) throws Exception
	{	
		WebElement elem = driver.findElement(by);
		if(driver instanceof JavascriptExecutor)
		{ ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3 px solid red'",elem);
			}
		return elem;
}
	
}
