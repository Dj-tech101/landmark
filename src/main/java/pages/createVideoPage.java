package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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

import base.controlAction;

public class createVideoPage extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public createVideoPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='Name']")
	WebElement nameField;

	public void sendVideoname(String name) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);

	}

	@FindBy(xpath = "(//button[contains(text(),' OPEN FILE ')])[2]")
	WebElement openFileForOverlay;

	@SuppressWarnings("deprecation")
	public void sendKeysOverlayField() throws IOException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMillis(1));
		try {
			Thread.sleep(2000);
			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(openFileForOverlay));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", e2);

			Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\autoitfiles.exe");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

	@FindBy(xpath = "//button[contains(text(),' NEXT ')]")
	WebElement nextButton;

	public void clickNextButton() throws InterruptedException {

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		;

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(xpath = "(//button[contains(text(),'SAVE')])[2]")
	WebElement saveButton;

	public void clickonSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

//		FluentWait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
//				.pollingEvery(Duration.ofMinutes(1))
//
//				.withMessage("element is not display");
//
//		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		js = (JavascriptExecutor) driver;

		Thread.sleep(2000);

		js.executeScript("arguments[0].click();", saveButton);

	}

	@FindBy(xpath = "//input[@name='Length']")

	WebElement lenthField;

	public void sendLength() {
		for (int i = 0; i < 2; i++) {

			Random ran = new Random();
			int number = ran.nextInt(15);

			if (number != 0) {
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
				wait = new WebDriverWait(driver, Duration.ofMinutes(1));

				wait.until(ExpectedConditions.visibilityOf(lenthField)).sendKeys(String.valueOf(number));
				break;
			}

		}
	}

	public void createGifwithOverlay(String name) throws IOException, InterruptedException {

		createVideoPage video = new createVideoPage();

		video.sendVideoname(name);

		video.sendKeysOverlayField();

		video.clickNextButton();
		video.sendLength();
//		
		video.clickonSaveButton();

		VideoPage videoPage = new VideoPage();

		videoPage.clickOnClosedGifWindow(name);
//		

	}

}
