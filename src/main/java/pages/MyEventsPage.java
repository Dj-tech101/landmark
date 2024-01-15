package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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

public class MyEventsPage extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public MyEventsPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='eventName']")
	WebElement eventName;

	public String GetEventName() throws InterruptedException {

		// Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(eventName));

		return e1.getText();

	}

	@FindBy(xpath = "//a[contains(text(),'GO LIVE')]")
	private WebElement GoliveButton;

	public String getGoLiveButtontext() {

		return waitForElementToBeVisible(GoliveButton).getText();

	}

	@FindBy(xpath = "//input[@id='EventName']")
	private WebElement searchEventFiled;

	@FindBy(xpath = "//input[@id='searchEvent']")
	private WebElement searchEventButton;

	public void serachEventsAction(String eventName) {

		Actions act = new Actions(driver);

		act.sendKeys((waitForElementToBeVisible(searchEventFiled)), eventName).perform();

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(searchEventButton));

	}
	
	
	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editButton;
	
	public void clickOnEditButton() throws InterruptedException {
		
		Thread.sleep(1500);
		
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(editButton));

		
	}
	@FindBy(xpath = "//a[@title='Copy']")
	private WebElement CopyButton;
	
	public void clickOnCopyButton() throws InterruptedException {
		
		//Thread.sleep(1500);
//		try {
////			js = (JavascriptExecutor) driver;
////
////			js.executeScript("arguments[0].click();", (CopyButton));
//
//			Actions act= new Actions(driver);
//			act.click(CopyButton).perform();
//		} catch (StaleElementReferenceException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		
		for (int attempt = 0; attempt < 3; attempt++) {
            try {
                CopyButton.click();
                break;  // Break the loop if the click was successful
            } catch (StaleElementReferenceException e) {
                // Handle the exception or just retry
                System.out.println("StaleElementReferenceException. Retrying...");
            }
        }
		
	}
	
	@FindBy(xpath = "//input[@name='NewEventName']")
	private WebElement NewEventNameFeild;
	
	public void sendNewEventName(String newName) {
		
		Actions act= new Actions(driver);
		act.sendKeys(NewEventNameFeild, newName).perform();
	}
	
	@FindBy(xpath = "//button[contains(text(),'OK') and @type='button']")
	private WebElement OkButton;
	
	public void clickOnOkButton() throws InterruptedException {
		
		//Thread.sleep(1500);
		
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", (OkButton));

		
	}
	
	
	
	
	public void copyExistEvent(String name) throws InterruptedException {
		
		clickOnCopyButton();
		sendNewEventName(name);
		clickOnOkButton();
		
		
		
		
	}
}
