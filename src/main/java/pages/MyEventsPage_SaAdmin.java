package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

public class MyEventsPage_SaAdmin extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public MyEventsPage_SaAdmin() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='EventName']")
	private WebElement searchEventField;

	@FindBy(xpath = "//input[@id='searchEvent']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='eventName']")
	private List<WebElement> eventNames;

	public void getSearchFunction(String data) throws InterruptedException {
		// search event name

		waitForElementToBeVisible(searchEventField).sendKeys(data);

		// click on search button

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(searchButton));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		Thread.sleep(1510);
	}

	public List<String> getlistofEventsOnPage() throws InterruptedException {

		List<String> values = new ArrayList<String>();
		waitUntillVsibilityOfAllElement(eventNames);
		for (WebElement eventsElement : eventNames) {

			// get one by one element

			Thread.sleep(1500);
			try {
				values.add(waitForElementToBeVisible(eventsElement).getText());
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		}

		return values;

	}

	@FindBy(xpath = "//span[@class='selection']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement SearchUsername;

	public void searchUserName(String Name) {

		waitForElementToBeClickable(userNameField).click();

		waitForElementToBeVisible(SearchUsername).sendKeys(Name);
		Actions act = new Actions(driver);

		act.keyDown(Keys.ENTER).perform();

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeClickable(searchButton));

	}

	@FindBy(xpath = "(//div[@class='row'])[4]/div/div/div/a")
	private WebElement userIdName;

	public String getNameOfUserNames() {

		String name = "";

		try {
			name = waitForElementToBeVisible(userIdName).getText();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Exception occurred: " + e.getMessage());
		} catch (TimeoutException e) {
			// TODO: handle exception
		}
		return name;

	}

	@FindBy(xpath = "//label[@class='switch']")
	private WebElement showAllSwitch;

	@FindBy(xpath = "//div[@class='accordion']")
	private List<WebElement> listOfElement;

	public void clickOnShowAllSwitch() throws InterruptedException {

		Actions act = new Actions(driver);

		showAllSwitch.click();
	}

	public int getCountElmentsPerPage() {
		int count = 0;
		for (WebElement element : listOfElement) {

			count++;

		}
		return count;
	}

	@FindBy(xpath = "(//ul[@class='pagination'])[1]/li[13]/a")
	private WebElement lastPaginationButton;

	public void clickOnlastPaginationButton() throws InterruptedException {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", waitForElementToBeVisible(lastPaginationButton));

		Thread.sleep(500);
	}

	public String getTextOfPegiButton() {

		return waitForElementToBeVisible(lastPaginationButton).getText();

	}

	@FindBy(xpath = "(//div[@class='col-12'])/div[1]")
	private WebElement totalCountBeforeSwitch;

	public String getTotalCountBeforeSwitch() {

		return (totalCountBeforeSwitch.getText());

	}

	public String getTotalCountAfterSwitch() throws InterruptedException {
		Thread.sleep(4000);
		return (waitForElementToBeVisible(totalCountBeforeSwitch).getText());

	}

	@FindBy(xpath = "(//li[@id='manageusers']/a)[1]")
	private WebElement manageUserButton;

	public void clickOnManageUserButton() {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(manageUserButton));

	}

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement SearchUsernameFileds;

	public void searchUserNameManageUser(String Name) {

		waitForElementToBeClickable(userNameField).click();

		waitForElementToBeVisible(SearchUsername).sendKeys(Name);
		Actions act = new Actions(driver);

		act.keyDown(Keys.ENTER).perform();

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeClickable(SearchUsernameFileds));

	}

	@FindBy(xpath = "//tr[@class='#3C444C']/td")
	private List<WebElement> userInformation;

	public List<String> getInformationOfUser() throws InterruptedException {
		List<String> info = new ArrayList<String>();
		int attempt = 0;
		while (attempt < 3) {

			try {
				for (WebElement element : userInformation) {

					String text = element.getText();

					info.add(text);

				}
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
				System.out.println(e.getLocalizedMessage());
			}
			attempt++;

		}
		return info;

	}

	@FindBy(xpath = "(//a[@title='Share'])[1]")
	private WebElement shareIcon;

	public void getClickShareIcon() {

		try {

			Thread.sleep(1500);

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeVisible(shareIcon));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
	}

}
