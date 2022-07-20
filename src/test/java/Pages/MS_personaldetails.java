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

public class MS_personaldetails {

	 WebDriver driver;
	 
		ExtentTest logger;
		ExtentReports extent;
		String screenShotPath;
		String TestScriptName;
			
		public void persondetails(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReports extent)
			{
				this.driver = driver;
				this.logger=logger;
				this.extent=extent;
				this.TestScriptName=TestScriptName;
			}
			

		public  void Addpersonal_details(String firstname,String lastname,String emp_ID) throws Exception
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			findElement(By.id("menu_pim_viewPimModule")).click();
			findElement(By.id("menu_pim_viewEmployeeList")).click();
			
			findElement(By.xpath("//a[contains(text(),'0345')]")).click();
			
			findElement(By.xpath("//input[@id='btnSave']")).click();
			findElement(By.name("personal[txtEmpFirstName]")).clear();
			findElement(By.name("personal[txtEmpFirstName]")).sendKeys(firstname);
			findElement(By.id("personal_txtEmpLastName")).sendKeys(lastname);
			findElement(By.id("personal_txtEmployeeId")).sendKeys(emp_ID);
			findElement(By.id("personal_optGender_1")).click();
			
	Select dropdown = new Select(driver.findElement(By.id("personal_cmbMarital")));
				dropdown.selectByVisibleText("Married");
				
	Select dropdown1 = new Select(driver.findElement(By.id("personal_cmbNation")));
				dropdown1.selectByVisibleText("Indian");
				Thread.sleep(10000);
				
			findElement(By.id("btnSave"));
			
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("MS_personaldetails - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
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

	
	
	
