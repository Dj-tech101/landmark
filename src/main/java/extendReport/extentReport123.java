package extendReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport123 {

	public static void main(String[] args) {

		ExtentReports extentReports = new ExtentReports();

		ExtentSparkReporter spartReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir")+"\\screen\\report.html"));

		extentReports.attachReporter(spartReporter);
		
		ExtentTest test=extentReports.createTest("test case 1");
		test.pass("test case is pass");
		

		ExtentTest test2=extentReports.createTest("test case 2");
		test.log(Status.FAIL, "test case is fail");
		

		ExtentTest test3=extentReports.createTest("test case 3");
		test.log(Status.SKIP, "test case is fail");
		
		
		extentReports.flush();

	}
}
