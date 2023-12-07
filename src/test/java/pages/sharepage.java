package pages;

import java.beans.DesignMode;
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

		WebElement e1=wait.until(ExpectedConditions.visibilityOf(printSwitch));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedPhotoButton;

	public void clickOnClosedPhotoWindow() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement element = wait.until(ExpectedConditions.visibilityOf(closedPhotoButton));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}
	
	public void CreateNewShareNode(String shareOptions) {
		sharepage sharenode = new sharepage(driver);

		sharenode.getlistofshareOptions(shareOptions);

		sharenode.clickonPrintSwitch();

		sharenode.clickOnClosedPhotoWindow();

		
		
	}

}
