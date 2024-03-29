package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import io.netty.handler.timeout.TimeoutException;

public class createPhotoPage extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public createPhotoPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='Name']")
	WebElement nameTextField;

	public void sendNameTextField(String nameofphoto) throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(1500))
				.pollingEvery(Duration.ofSeconds(100)).ignoring(Exception.class); // Ignore exceptions for more
																					// robustness

		WebElement send = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Name']")));

		send.sendKeys(nameofphoto);

//		e2.sendKeys(nameofphoto);

	}

	@FindBy(xpath = "//input[@role='switch']")
	private WebElement autoRemovalButton;

	public void getClickonAAutoRemovalbackButton() {

		try {

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(autoRemovalButton));

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "(//button[contains(text(),' OPEN FILE ')])[2]")
	WebElement openFileForOverlay;
	
	@FindBy(tagName = "img")
	private WebElement img;
	

	@SuppressWarnings("deprecation")
	public void sendKeysOverlayField() throws IOException, TimeoutException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMillis(1));
		try {
			Thread.sleep(3000);
			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(openFileForOverlay));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", e2);

			Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\autoitfiles overlay.exe");
			
			Thread.sleep(3000);
		//	waitForElementToBeVisible(img);
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[1]")
	private WebElement GreenScreenToggle;

	public void clickOnGreenScreenToggle() {

		try {
			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(GreenScreenToggle));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[2]")
	private WebElement backgroundRemoval;

	public void clickOnAutoBackgroundRemovalToggle() {

		try {
			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(backgroundRemoval));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "((//div[@class='image-setting-buttons'])/*[@class='btn-create'])[1]")
	private WebElement openBackroundSection;

	public WebElement getopenBackroundSectionElement() {
		return waitForElementToBeVisible(openBackroundSection);
	}

	@SuppressWarnings("deprecation")
	public void sendKeysBackgroundImage() throws IOException, InterruptedException {
//		boolean value = false;
//
//		try {
//
//			String areaChecked = waitForElementToBeVisible(GreenScreenToggle).getAttribute("class");
//			if (CheckedGreenScreenToggle()) {
//				System.out.println("Toggle is on");
//			} else {
//				js = (JavascriptExecutor) driver;
//
//				js.executeScript("arguments[0].click();", waitForElementToBeVisible(GreenScreenToggle));
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//
//			System.out.println(e.getMessage());
//		}

		Thread.sleep(1200);

		try {

//			System.out.println("ready to click on background");
//			WebElement background = wait.until(ExpectedConditions.elementToBeClickable(openBackroundSection));

//			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
//					.pollingEvery(Duration.ofSeconds(100)).withMessage("not define");
//
//			WebElement background = wait.until(ExpectedConditions.visibilityOf(openBackroundSection));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(openBackroundSection));

//			background.click();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

		Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\backround autoIt.exe");

	}

	public boolean CheckedGreenScreenToggle() {

		boolean value = false;

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		try {

			wait = new WebDriverWait(driver, Duration.ofMinutes(1));

			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(GreenScreenToggle));

			String areaChecked = waitForElementToBeVisible(GreenScreenToggle).getAttribute("aria-checked");

			if (areaChecked.equals("true")) {

				value = true;

			} else {
				value = false;

			}
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return value;
	}

	@FindBy(xpath = "//div[@class='footer']/*")
	WebElement saveButton;

	public void clickonSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

//		FluentWait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
//				.pollingEvery(Duration.ofMinutes(1))
//
//				.withMessage("element is not display");
//
//		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		js = (JavascriptExecutor) driver;

		// Thread.sleep(500);

		js.executeScript("arguments[0].click();", saveButton);

	}

	@FindBy(xpath = "//button[contains(text(),' ADD PHOTO PLACEHOLDER ')]")
	private WebElement addPhotoTemplatePlace;

	public void clickonaddPhotoTemplatePlace() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));

		js = (JavascriptExecutor) driver;

		// Thread.sleep(1500);

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(addPhotoTemplatePlace));

		Thread.sleep(1500);

	}

	@FindBy(xpath = "//div[@class='messages']/span")
	private WebElement ValidationmessagePhototemplate;

	public String getValidationText() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		String text = wait.until(ExpectedConditions.visibilityOf(ValidationmessagePhototemplate)).getText();

		return text;
	}
}
