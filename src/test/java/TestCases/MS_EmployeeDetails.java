package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
import Pages.HomePage;
import Pages.MS_contactdetails;
import Pages.MS_dependents;
import Pages.MS_emergencyContact;
import Pages.MS_login;
import Pages.MS_personaldetails;

public class MS_EmployeeDetails {

/*private static final String name = null;
private static final String adress_street1 
= null;
private static final String username = null;*/


WebDriver driver;
	
	
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName;
	 public static String TestName;
	
	@BeforeTest 
	public void  TestSetup()throws Exception {
		
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Datatable=eat.getDataTable("C:\\HTML Report\\OrangeHRM6\\MS_EMPExport4.xlsx", "Sheet1");
		
		TestScriptName=(Datatable.get("MS01").get("TestName"));
		
		//"C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1"
		//Extent HTML Report Creation Starts
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		 String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
		  
	
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
		//Extent HTML Report Creation Ends
	}
	
	
	@Test
	public void EmployeeDetails() throws Exception 
	
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		/*System.out.println(Datatable.get("TC01").get("UserName"));
		System.out.println(Datatable.get("TC01").get("Password"));
		System.out.println(Datatable.get("TC01").get("Nationality"));*/
		//MS_EmployeeDetails

		String username= Datatable.get("MS01").get("username");
		String password= Datatable.get("MS01").get("password");
	

		//	personaldetails	
		String firstname=Datatable.get("MS01").get("firstname");
		String lastname=Datatable.get("MS01").get("lastname");
		String emp_ID= Datatable.get("MS01").get("emp_ID");

		//contactdetails		
		String adress=Datatable.get("MS01").get("adress_street1");
		String city=Datatable.get("MS01").get("city");
		String state= Datatable.get("MS01").get("state");
		
		//String mobile= Datatable.get("MS01").get("mobile");

		//emergency contact		
		String name1=Datatable.get("MS01").get("name");
		String relationship=Datatable.get("MS01").get("relationship");
		String mobile1= Datatable.get("MS01").get("mobile1");
		
		//emergency contact		
		String dependent=Datatable.get("MS01").get("dependent_name");
		//String relation=Datatable.get("MS01").get("depend_relation");
		
		MS_login l1 = new MS_login();
		l1.login(driver,TestScriptName,logger,extent);
		l1.loginpage(username,password);
		
		MS_personaldetails P1= new MS_personaldetails();
		P1.persondetails(driver,TestScriptName,logger,extent);
		P1.Addpersonal_details(firstname,lastname,emp_ID);
		
		MS_contactdetails C1=new MS_contactdetails();
		C1.contactdetails(driver,TestScriptName,logger,extent);
		C1.Addpersonaldetails(adress,city,state);
		
		MS_emergencyContact E1=new MS_emergencyContact();
		E1.emergencycontact(driver,TestScriptName,logger,extent);
		E1.contact_details(name1,relationship,mobile1);
		
		MS_dependents D1=new MS_dependents();
		D1.dependents(driver,TestScriptName,logger,extent);
		D1.dependent_details(dependent);
		
		
		HomePage H1= new HomePage();
		H1.HomePage(driver,TestScriptName,logger,extent);
		H1.Logout();
	}
	
	
	@AfterTest 
	public void  TestCloser()throws Exception {	
		//driver.quit();
		//extent.flush();
	}
	
}
