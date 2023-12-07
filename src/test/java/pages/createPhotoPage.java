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

public class createPhotoPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public createPhotoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
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

	@FindBy(xpath = "(//button[contains(text(),' OPEN FILE ')])[2]")
	WebElement openFileForOverlay;

	@SuppressWarnings("deprecation")
	public void sendKeysOverlayField() throws IOException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMillis(3));

		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(openFileForOverlay));

		e2.click();

		Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\autoitfiles.exe");

	}

	@FindBy(xpath = "(//button[contains(text(),'SAVE')])[2]")
	WebElement saveButton;

	public void clickonSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(4));

		FluentWait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofMinutes(1))

				.withMessage("element is not display");

		WebElement e2 = wait.until(ExpectedConditions.visibilityOf(saveButton));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e2);

	}
	
	public void createNewNameofPhoto() {
		
	}
}
