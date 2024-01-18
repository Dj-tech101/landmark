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

	@FindBy(xpath = "//div[@class='footer']/*")
	WebElement saveButton;

	public void clickonSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

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

	public void createGifwithOverlayForBackground(String name) throws IOException, InterruptedException {

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

	public void createNewVideoWithoutBackground(String nameofVideo, String Type) throws IOException, InterruptedException
		
	{
		createVideoPage video = new createVideoPage();

		video.sendVideoname(nameofVideo);

		getClickonAAutoRemovalbackButton();

		if (Type.contains("GS") || Type.contains("greenScreen")) {

			clickOnGreenScreenToggle();
			sendKeysBackgroundImage();
			sendKeysOverlayField();
			
			video.clickNextButton();
			video.sendLength();
//			
			video.clickonSaveButton();

			VideoPage videoPage = new VideoPage();

			videoPage.clickOnClosedGifWindow(nameofVideo);

		} else if (Type.equals("BR") || Type.contains("Background")) {

			clickOnGreenScreenToggle();
			
			clickOnAutoBackgroundRemovalToggle();

			sendKeysBackgroundImage();

			sendKeysOverlayField();
			video.clickNextButton();
			video.sendLength();
//			
			video.clickonSaveButton();

			VideoPage videoPage = new VideoPage();

			videoPage.clickOnClosedGifWindow(nameofVideo);

//			createPhoto.clickonSaveButton();
//
//			photopage.clickOnClosedPhotoWindow(nameofphoto);
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
}
