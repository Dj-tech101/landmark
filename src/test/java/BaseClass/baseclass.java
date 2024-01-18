package BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.TakescreenShotUtils;
import Utility.propertyFile;
import base.controlAction;

public class baseclass {
	public WebDriver driver;
	public WebDriverWait wait;

	public static ExtentReports extentReports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest extenttest;

	@BeforeClass
	public void setup(ITestContext context) throws InterruptedException, IOException {

		controlAction.launchBrowser();
		
		extenttest = extentReports.createTest(context.getName());
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		
		//controlAction.closeBrowser();
	}

	@BeforeSuite
	public void initializedExtendReport() throws IOException {
		
		Date date = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd_hh_mm_ss");
		String dateFormate = formatter.format(date);
		String path = System.getProperty("user.dir") + "\\screen\\report"+dateFormate+".html";
		sparkReporter = new ExtentSparkReporter(new File(path));
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		// add system information
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.specification.version"));
		extentReports.setSystemInfo("Username", System.getProperty("user.name"));
		extentReports.setSystemInfo("Os version", System.getProperty("os.version"));
		extentReports.setSystemInfo("Os version", System.getProperty("os.version"));
		extentReports.setSystemInfo("App url", new propertyFile().getUrl());

		// add config.
		sparkReporter.config().setDocumentTitle("Landmark test Report");
		sparkReporter.config().setReportName("Dj_Tester");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("MM-dd-yyyy HH:mm:ss");

	//	sparkReporter.loadJSONConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resource\\extent-report-config.json"));
	}

	@AfterSuite
	public void generateExtendReport() {
		extentReports.flush();
	}
	
	@AfterMethod
	public void checkStatus(Method m,ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			String ScreenShotPath=null;
			ScreenShotPath=controlAction.takeScreenshot(result.getTestContext().getName());
		//	extenttest.addScreenCaptureFromPath(ScreenShotPath, "Demo of fail Test case");
			extenttest.addScreenCaptureFromBase64String(controlAction.takeScreenshot(m.getName()));
			extenttest.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			
			extenttest.pass(m.getName()+" is passed");
		} 
	}
}
