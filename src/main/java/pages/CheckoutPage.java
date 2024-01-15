package pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.TakescreenShotUtils;
import base.controlAction;

public class CheckoutPage extends controlAction {
	// public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	public CheckoutPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='FirstName']")
	static WebElement firstName;

	public static void sendFirstName(String name) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			WebElement firstName1 = wait.until(ExpectedConditions.visibilityOf(firstName));

			firstName1.sendKeys(name);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "//input[@name='LastName']")
	static WebElement Lastname;

	public static void sendLastName(String name) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			WebElement Lastname1 = wait.until(ExpectedConditions.visibilityOf(Lastname));

			Lastname1.sendKeys(name);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "(//input[@id='Zip'])[2]")
	static WebElement zip;

	public static void sendZip(String zipvalue) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

//		System.out.println("enter zip number");
		zip.sendKeys(zipvalue);
		Thread.sleep(1500);

	}

	@FindBy(xpath = "//select[@id='CardType']")
	static WebElement cardType;

	public static void selectCardType() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			cardType.click();
			Select select = new Select(cardType);

			select.selectByVisibleText("Visa");

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	@FindBy(xpath = "//input[@id='CardNumber']")
	static WebElement cardNumber;

	public static void sendcardNumber(String cardNumberDat) {

		cardNumber.sendKeys(cardNumberDat);

	}

	@FindBy(xpath = "//input[@id='CardCSVNumber']")
	static WebElement csv;

	public static void sendCsv(String cardNumberDat) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			WebElement Lastname1 = wait.until(ExpectedConditions.visibilityOf(csv));

			Lastname1.sendKeys(cardNumberDat);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@FindBy(xpath = "//select[@id='ExpiryMonth']")
	static

	WebElement expireMonth;

	public static void selectExpireMonth(int Month) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			WebElement Lastname1 = wait.until(ExpectedConditions.visibilityOf(expireMonth));

			Lastname1.click();
			Thread.sleep(500);

			Select select = new Select(Lastname1);

			List<WebElement> listofOptions = select.getOptions();

			for (int i = 0; i < listofOptions.size(); i++) {

				if (i == Month) {

					String value = listofOptions.get(i).getText();

					System.out.println(value);

					select.selectByVisibleText(value);

					break;

				}
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	@FindBy(xpath = "//select[@id='ExpiryYear']")
	static

	WebElement expireYear;

	public static void selectExpireYear(String year) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			WebElement Lastname1 = wait.until(ExpectedConditions.visibilityOf(expireYear));

			Lastname1.click();

			Select select = new Select(Lastname1);
			select.selectByVisibleText(year);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	@FindBy(xpath = "//button[@id='btnPayLater']")
	private WebElement paylaterButton;

	public void clickOnPayLaterButton() {

		try {
			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(paylaterButton));
			
		} catch (UnhandledAlertException e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}
	
	

	@FindBy(xpath = "//button[contains(text(),'PAY NOW ')]")
	WebElement PayNowButton;

	@FindBy(xpath = "//button[@id='btnPaynow']")
	WebElement saveNow;

	@FindBy(xpath = "(//input[@name='UseExistingCard'])[1]")
	WebElement paymentDetaiils;

	public void FillNeccessoryCardDetails(String value) throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1250));

		boolean ref = false;

		if (value.equalsIgnoreCase("New")) {
			ref = true;

		} else {
			ref = false;

		}
		System.out.println("value for ref " + ref);

		if (ref) {

//			System.out.println("eneter the name ");
			sendFirstName("mahesh");

//			System.out.println("enter the last name ");
			sendLastName("mahesh232323");
			sendZip("233344");

			sendcardNumber("4032030965018386");
			sendCsv("136");
			selectCardType();
			selectExpireMonth(8);
			selectExpireYear("2026");

			try {

				js = (JavascriptExecutor) driver;

//				System.out.println("lets click on paynow button");
				js.executeScript("arguments[0].click();", waitForElementToBeClickable(PayNowButton));

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		} else {

			try {
				wait = new WebDriverWait(driver, Duration.ofMinutes(1));

				WebElement element = wait.until(ExpectedConditions.visibilityOf(saveNow));

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", element);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}

	}
}
