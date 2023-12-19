package BaseClass;

import java.io.File;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;


public class baseclass {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setup() throws InterruptedException {
		
		driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.get("https://lkstaging.photopartyupload.com/");

	}

	@AfterMethod
	public void tearDown() {
		//driver.close();

	}
}
