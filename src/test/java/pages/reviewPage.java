package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reviewPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	public reviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='btnAngularReviewNext']")
	WebElement nextButton;

	public void clickNextButton() throws InterruptedException {

//
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
//

		try {
			Thread.sleep(1000);

			js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,250)", "");

			wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
			Actions act = new Actions(driver);

			js.executeScript("arguments[0].click();", nextButton);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
		Thread.sleep(1000);

		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,250)", "");

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
		Actions act = new Actions(driver);
		System.out.println("lets click");
		js.executeScript("arguments[0].click();", nextButton);

		// act.moveToElement(nextButton).click().build().perform();
	}

}
