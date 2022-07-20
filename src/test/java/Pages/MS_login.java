package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Extent_Reports.ExtentReport;

public class MS_login {
	

	WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String TestScriptName;
	String screenShotPath;

	public void login(WebDriver driver, String TestScriptName, ExtentTest logger, ExtentReports extent) {
		// TODO Auto-generated method stub	
	
	
		this.driver=driver;
		this.logger=logger;
		this.extent = extent;
		this.TestScriptName=TestScriptName;
	}
	
public void loginpage(String username,String password) throws Exception
{	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	
	findElement(By.name("txtUsername")).sendKeys(username);
	findElement(By.id("txtPassword")).sendKeys(password);
	findElement(By.id("btnLogin"));
	
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("login page - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	
	findElement(By.id("btnLogin")).click();
	
}
	
public WebElement findElement(By by)throws Exception 
{

	WebElement elem = driver.findElement(by);  
	
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	return elem;
}

}
	
	

