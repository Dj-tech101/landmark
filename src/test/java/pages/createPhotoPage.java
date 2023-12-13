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
		try {
			Thread.sleep(3000);
			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(openFileForOverlay));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", e2);

			Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\autoitfiles.exe");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

	@FindBy(xpath = "//input[@role='switch']")
	WebElement GreenScreenToggle;

	@FindBy(xpath = "(//button[contains(text(),' OPEN FILE ')])[1]")
	WebElement openBackroundSection;

	@SuppressWarnings("deprecation")
	public Boolean sendKeysBackgroundImage() throws IOException, InterruptedException {
		boolean value = false;

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(3));

			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(GreenScreenToggle));

			String areaChecked = e2.getAttribute("aria-checked");
			if (CheckedGreenScreenToggle()) {
				System.out.println("Toggle is on");
			} else {
				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", e2);

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

		Thread.sleep(1200);

		WebElement background = wait.until(ExpectedConditions.elementToBeClickable(openBackroundSection));

		background.click();

		Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\backround autoIt.exe");
		return value;

	}

	public boolean CheckedGreenScreenToggle() {

		boolean value = false;

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(3));

			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(GreenScreenToggle));

			String areaChecked = e2.getAttribute("aria-checked");

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

	@FindBy(xpath = "(//button[contains(text(),'SAVE')])[2]")
	WebElement saveButton;

	public void clickonSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofMinutes(4));

//		FluentWait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
//				.pollingEvery(Duration.ofMinutes(1))
//
//				.withMessage("element is not display");
//
//		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		js = (JavascriptExecutor) driver;

		Thread.sleep(4000);

		js.executeScript("arguments[0].click();", saveButton);

	}

	public void createNewNameofPhoto() {

	}
}
