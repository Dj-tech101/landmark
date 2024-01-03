package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class PhotoPage extends controlAction {

	//public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public PhotoPage() {
		// TODO Auto-generated constructor stub

		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(),'Create New')]")

	WebElement createPhotoButton;

	public void clickonCreatePhotoButton() throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(createPhotoButton));

		Thread.sleep(500);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e1);

		// e1.click();
//		Actions act = new Actions(driver);
//		act.click(e1).perform();

	}

	@FindBy(xpath = "//div[contains(text(),'Single Image')]")

	WebElement singleImgaeButton;

	public void clickOnSingleImageButton() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(singleImgaeButton));

		
		Actions act = new Actions(driver);
		act.click(waitForElementToBeVisible(singleImgaeButton)).perform();

	}

	@FindBy(xpath = "//div[contains(text(),'Photo Template')]")
	private WebElement PhotoTempalteButton;

	public void clickOnPhotoTemplateButton() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(PhotoTempalteButton));

		Actions act = new Actions(driver);
		act.click(waitForElementToBeVisible(PhotoTempalteButton)).perform();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		

	}

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedPhotoButton;

	@FindBy(xpath = "//div[@class='name']")
	List<WebElement> listofthephotos;

	public void clickOnClosedPhotoWindow(String expectedname) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions.visibilityOf(closedPhotoButton));

		for (WebElement elements : listofthephotos) {

			String actualPhotoname = elements.getText();

			if (actualPhotoname.equalsIgnoreCase(expectedname)) {

//				 Wait<WebDriver> wait = new FluentWait<>(driver)
//			                .withTimeout(Duration.ofSeconds(1500))
//			                .pollingEvery(Duration.ofSeconds(1500))
//			                .ignoring(Exception.class); // Ignore exceptions for more robustness

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", element);

				break;

			}
		}

	}

	public void createNewSinglePhoto(String nameofphoto) throws InterruptedException, IOException {

		PhotoPage photopage = new PhotoPage();

		photopage.clickonCreatePhotoButton();

		photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage();

		createPhoto.sendNameTextField(nameofphoto);

		createPhoto.sendKeysBackgroundImage();

		createPhoto.sendKeysOverlayField();

		createPhoto.clickonSaveButton();

		photopage.clickOnClosedPhotoWindow(nameofphoto);

	}

	

	
	public void createNewPhotoTemplate(String nameofphoto) throws InterruptedException, IOException {

		PhotoPage photopage = new PhotoPage();

		photopage.clickonCreatePhotoButton();

		photopage.clickOnPhotoTemplateButton();

		createPhotoPage createPhoto = new createPhotoPage();

		createPhoto.sendNameTextField(nameofphoto);
		
		//createPhoto.sendKeysBackgroundImage();

		createPhoto.sendKeysOverlayField();
		
		createPhoto.clickonaddPhotoTemplatePlace();

		createPhoto.clickonSaveButton();

		photopage.clickOnClosedPhotoWindow(nameofphoto);

	}
}
