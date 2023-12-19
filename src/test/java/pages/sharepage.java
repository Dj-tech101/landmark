package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.TakescreenShotUtils;

public class sharepage {

	public static WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public sharepage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static void loadpage(int duration) {

		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FindBy(tagName = "mat-button-toggle")
	List<WebElement> listOfShareOptions;

	public void getlistofshareOptions(String execpedvalue) {

		loadpage(2);
		for (WebElement shareList : listOfShareOptions) {

			wait = new WebDriverWait(driver, Duration.ofMinutes(2));

			wait.until(ExpectedConditions.visibilityOfAllElements(listOfShareOptions));

			String actualValue = shareList.getAttribute("value");

			// System.out.println("share actual vakue is " + actualValue);
			if (actualValue.contains(execpedvalue)) {

				shareList.click();
			}
		}
	}

	@FindBy(xpath = "//input[@role='switch']")
	WebElement printSwitch;

	public void clickonPrintSwitch() {

		loadpage(2);

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(printSwitch));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedPhotoButton;

	public void clickOnClosedPhotoWindow() throws IOException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		try {
			wait = new WebDriverWait(driver, Duration.ofMinutes(2));

			WebElement element = wait.until(ExpectedConditions.visibilityOf(closedPhotoButton));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public void CreateNewShareNode(String shareOptions) throws IOException {
		sharepage sharenode = new sharepage(driver);

		sharenode.getlistofshareOptions(shareOptions);

		sharenode.clickonPrintSwitch();

		sharenode.clickOnClosedPhotoWindow();

	}

	@FindBy(xpath = "(//a[contains(text(),'CLICK HERE')])[3]")
	WebElement clickHereButton;

	public void ClickOnButton() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(clickHereButton));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(xpath = "//input[@name='subject']")
	WebElement nameField;

	public void SendNameField() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(nameField));

		e1.sendKeys("test email");

	}

	public void CreateNewShareNodemore(String shareOptions, String secondoption)
			throws IOException, InterruptedException {

		sharepage sharenode = new sharepage(driver);

		boothDesignPage designPage = new boothDesignPage(driver);

		designPage.clickonShareGearIcon();

		sharenode.getlistofshareOptions(shareOptions);

		sharenode.clickonPrintSwitch();

		sharenode.ClickOnButton();

		// TakescreenShotUtils.GetScreenShot(driver);

		sharenode.SendNameField();

		Thread.sleep(1500);

		sharenode.getlistofshareOptions(secondoption);

		sharenode.clickonPrintSwitch();

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		Thread.sleep(500);
		//TakescreenShotUtils.GetScreenShot(driver);
		sharenode.clickOnClosedPhotoWindow();

	}

	public void CreateNewShareNodeSmugmug(String shareOptions) throws IOException, InterruptedException {

		Thread.sleep(1000);
		sharepage sharenode = new sharepage(driver);

		boothDesignPage designPage = new boothDesignPage(driver);

		designPage.clickonShareGearIcon();

		sharenode.getlistofshareOptions(shareOptions);

		sharenode.clickonPrintSwitch();

		// sharenode.ClickOnButton();

	//	TakescreenShotUtils.GetScreenShot(driver);
		// sharenode.SendNameField();
		sharenode.clickOnClosedPhotoWindow();

	}

}
