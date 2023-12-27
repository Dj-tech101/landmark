package BaseClass;

import java.io.IOException;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import Utility.TakescreenShotUtils;
import base.controlAction;

public class baseclass {
	public  WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void setup() throws InterruptedException, IOException {

		controlAction.launchBrowser();
	}

	@AfterMethod
	public void tearDown() throws IOException {

		//controlAction.closeBrowser();
	}

}
