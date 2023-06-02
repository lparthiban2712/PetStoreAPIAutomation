package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener {
	
	ExtentSparkReporter sparkreporter;
	ExtentReports extentreport;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String Timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.MM.SS").format(new Date());
		String reportname="Test-Report"+Timestamp+".html";
		sparkreporter=new ExtentSparkReporter(".\\Reports\\"+reportname);
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(sparkreporter);
		
	}
	public void onTestSuccess(ITestResult result) {
		test=extentreport.createTest(result.getName());
		test.log(Status.PASS, "test case is passed");
				
	}
	public void onTestFailure(ITestResult result) {
		test=extentreport.createTest(result.getName());
		test.log(Status.FAIL, "test case is failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	public void onTestSkipped(ITestResult result) {
		test=extentreport.createTest(result.getName());
		test.log(Status.SKIP, "test case is skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}

	
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	  { 
		  //	  TODO Auto-generated method stub
	  
	  }
	  
	  public void onStart(ITestContext context) 
	  { 
		  // TODO Auto-generated method stub
	  
	  }
	 
	public void onFinish(ITestContext context) {
		extentreport.flush();
		
	}

}
