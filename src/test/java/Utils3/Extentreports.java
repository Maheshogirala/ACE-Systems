package Utils3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases3.Base3;

public class Extentreports implements ITestListener {

	// defind the webElement 
	public static ExtentSparkReporter sp;
	public static ExtentReports reports;
	public static ExtentTest test;
	// time stamp 
	 String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());	
	public void onStart(ITestContext context) {
	    // set the document path 
		
		sp= new ExtentSparkReporter(System.getProperty("user.dir")+"/Extentreports/"+timestamp+"Report1.htlm");
		                              //-----      we can use \\Extentreports\\
		// set the document title 
		sp.config().setDocumentTitle("Testing doc");
		// set the report title 
		sp.config().setReportName("Report1");
		// set the Them of the document 
		
		sp.config().setTheme(Theme.STANDARD);
		
		// using Reports set the system information 
		
		// Initiate the reports 
		reports =new ExtentReports();
		// attach the spark reporter to reports
		reports.attachReporter(sp);
		reports.setSystemInfo("Tester name","Mahesh");
		reports.setSystemInfo("Test Environment", "QA");
				
	  }
	
	public void onTestSuccess(ITestResult result) {
	    test= reports.createTest(result.getName());
	    test.log(Status.PASS, "Test passed");
	   		
	  }
	
	public void onTestFailure(ITestResult result) {
	    test = reports.createTest(result.getName());
	    test.log(Status.FAIL, "Test case fail"+result.getName());
	    try {
	    String imagepath= new Base3().screenshot(result.getName());
		test.addScreenCaptureFromPath(imagepath);
	    }catch(Exception e) {
	    	e.getStackTrace();
	    }
	  }
	
	public void onTestSkipped(ITestResult result) {
	   test=reports.createTest(result.getName());
	   test.log(Status.SKIP, "Test is skipped ");
		
	  }
	
	public void onFinish(ITestContext context) {
	    reports.flush();
	  }
	
	
	
	
	
	
	
	
	
}
