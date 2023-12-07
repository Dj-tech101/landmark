package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyEventsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public MyEventsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='eventName']")
	WebElement eventName;

	public String GetEventName() throws InterruptedException {
	
		//Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));

		wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(eventName));

		return e1.getText();

	}
}
