package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

import base.controlAction;

public class eventDetailsPage extends controlAction {
	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public eventDetailsPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;

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

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

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

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

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

		eventDetailsPage eventDetails = new eventDetailsPage();
		eventDetails = new eventDetailsPage();
		eventDetails.eventNameSendkeys(NameOfEvent);
		eventDetails.startNowRadioButton();
		eventDetails.timeZoneSelection("Delhi");
		eventDetails.contrySelection("India");
		eventDetails.stateSelection("Maharashtra");
		eventDetails.citySendkeys("pune");
		eventDetails.clickNextButton();

	}

	@FindBy(xpath = "//input[@id='StartDate']")
	private WebElement startTime;

	public void clickOnStartTimeField() {

		System.out.println("lets click on start time ");

//		js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", waitForElementToBeVisible(startTime));

		startTime.click();
	}

	public void selectDateElement(String systemDate) {

		List<WebElement> rowList = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		int i = 0;

		for (WebElement element : rowList) {
			i++;
			String classtext = element.getText();

			System.out.println("available date is" + classtext);

			if (i == 2) {

				waitForElementToBeVisible(element).click();

				break;

			}
		}
	}

	/*
	 * for (int i = 0; i < rowList.size(); i++) {
	 * 
	 * By datefield = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["
	 * + i + "]/td");
	 * 
	 * String fieldStatus = driver.findElement(datefield).getAttribute("class");
	 * 
	 * System.out.println("for " + i + " fils status is " + fieldStatus);
	 * 
	 * System.out.println("check it contain disable ");
	 * 
	 * // if (fieldStatus.contains("disabled")) { // // continue; // // } else { //
	 * By datefieldactual =
	 * By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[" + i +
	 * "]/td/span"); // // WebElement element = driver.findElement(datefieldactual);
	 * // String actualDate = element.getText(); // //
	 * System.out.println("my actual date is" + actualDate); // // if
	 * (actualDate.equals(systemDate)) { // //
	 * System.out.println("lets clcik on system date"); // js = (JavascriptExecutor)
	 * driver; // js.executeScript("arguments[0].click();",
	 * waitForElementToBeVisible(element)); // // break; // // } //}
	 * 
	 * } }
	 */

	public void fillRequireDateAction() {
		clickOnStartTimeField();
		java.util.Date date = new java.util.Date();
		SimpleDateFormat form = new SimpleDateFormat("dd");
		String today = form.format(date);

		// System.err.println("today date is" + today);

		selectDateElement(today);

	}

	public void PaylaterFillNeccessoryDetailsForEvent(String NameOfEvent) throws InterruptedException {

		eventDetailsPage eventDetails = new eventDetailsPage();
		eventDetails = new eventDetailsPage();
		eventDetails.eventNameSendkeys(NameOfEvent);
		// eventDetails.startNowRadioButton();
		eventDetails.fillRequireDateAction();
		eventDetails.timeZoneSelection("Delhi");
		eventDetails.contrySelection("India");
		eventDetails.stateSelection("Maharashtra");
		eventDetails.citySendkeys("pune");
		eventDetails.clickNextButton();

	}

	public void copyEventFillNeccessoryDetailsForEvent() throws InterruptedException {

		eventDetailsPage eventDetails = new eventDetailsPage();
		// eventDetails = new eventDetailsPage();
		// eventDetails.eventNameSendkeys(NameOfEvent);
		// eventDetails.startNowRadioButton();
		eventDetails.fillRequireDateAction();
//		eventDetails.timeZoneSelection("Delhi");
//		eventDetails.contrySelection("India");
//		eventDetails.stateSelection("Maharashtra");
//		eventDetails.citySendkeys("pune");
		eventDetails.clickNextButton();

	}

}
