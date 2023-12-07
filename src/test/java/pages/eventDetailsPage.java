package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eventDetailsPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public eventDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='EventName']")
	WebElement eventName;

	public void eventNameSendkeys(String name) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(eventName)).sendKeys(name);
		;

	}

	@FindBy(xpath = "(//div[@class='slider round'])[7]")
	WebElement startNow;

	public void startNowRadioButton() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		js = (JavascriptExecutor) driver;

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(startNow));
		;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(id = "StartDate")
	WebElement startdate;

	public void startdateSendkeys(String name) {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(startdate)).sendKeys(name);
		;

	}

	@FindBy(xpath = "//span[contains(text(),'Select time zone')]")
	WebElement country;

	public void clickonCountryButton() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		js = (JavascriptExecutor) driver;

		try {

			Actions act = new Actions(driver);

			WebElement e2 = wait.until(ExpectedConditions.visibilityOf(country));
			;

			act.click(e2).perform();

		} catch (UnhandledAlertException e) {
			// TODO: handle exception
		}

	}

	@FindBy(xpath = "//input[@role='searchbox']")
	WebElement searchFeild;

	@FindBy(xpath = "//span[@class='select2-results']/ul/li")

	List<WebElement> searchList;

	public void timeZoneSelection(String name) throws InterruptedException {

		clickonCountryButton();

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(searchFeild)).sendKeys(name);
		;

		Thread.sleep(1000);
		;

//		for (int i = 0; i < searchList.size(); i++) {
//
//			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//			wait.until(ExpectedConditions.visibilityOf(searchList.get(i))).sendKeys(name);
//			;
//			String text = searchList.get(i).getText();
//			
		Actions act = new Actions(driver);

		act.sendKeys(Keys.DOWN.ENTER).perform();

		// }

	}

	@FindBy(id = "City")
	WebElement city;

	public void citySendkeys(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(name);
		;
		;
	}

	@FindBy(id = "StateSelected")
	WebElement state;

	public void stateSelection(String name) throws InterruptedException {

		Select se = new Select(state);

		Thread.sleep(1000);
		se.selectByVisibleText(name);
	}

	@FindBy(id = "CountrySelected")
	WebElement contry;

	public void contrySelection(String name) throws InterruptedException {

		Select se = new Select(contry);
		Thread.sleep(1000);
		se.selectByVisibleText(name);
	}

	@FindBy(id = "btnEventData")
	WebElement nextButton;

	public void clickNextButton() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
		;

	}

	public void eventSubmission() throws InterruptedException {

		eventNameSendkeys("testAutomation");
		startNowRadioButton();
		Thread.sleep(1000);

		timeZoneSelection("Delhi");
		Thread.sleep(1000);

		contrySelection("India");
		Thread.sleep(1000);
		stateSelection("Maharashtra");
		Thread.sleep(1000);

		citySendkeys("pune");

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
		;

	}

	public void FillNeccessoryDetailsForEvent(String NameOfEvent) throws InterruptedException {

		
		eventDetailsPage eventDetails = new eventDetailsPage(driver);
		eventDetails = new eventDetailsPage(driver);
		eventDetails.eventNameSendkeys(NameOfEvent);
		eventDetails.startNowRadioButton();
		eventDetails.timeZoneSelection("Delhi");
		eventDetails.contrySelection("India");
		eventDetails.stateSelection("Maharashtra");
		eventDetails.citySendkeys("pune");
		eventDetails.clickNextButton();
	
	
	}

}
