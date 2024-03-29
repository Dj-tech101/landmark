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

import base.controlAction;

public class createGifPage extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public createGifPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='Name']")
	WebElement nameField;

	public void sendGifname(String name) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);

	}

	@FindBy(xpath = "(//button[contains(text(),' OPEN FILE ')])[2]")
	WebElement openFileForOverlay;
	
	@FindBy(xpath = "(//div[@class='gif-holder'])[8]/div/div/img")
	private WebElement imageTag;
	

	public void sendKeysOverlayField() throws IOException {

		//driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

	//	wait = new WebDriverWait(driver, Duration.ofMillis(3));
		try {
			Thread.sleep(2000);
			WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(openFileForOverlay));

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", e2);

			Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\overlay.exe");

		//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3500));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

	@FindBy(xpath = "//button[contains(text(),' NEXT ')]")
	WebElement nextButton;
	
	

	public void clickNextButton() throws InterruptedException {

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		;

		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", e1);

		
		

	}

	@FindBy(xpath = "//div[@class='footer']/*")
	WebElement saveButton;

	public void clickonSaveButton() {
		
		 try {
	            js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", saveButton);
	        } catch (NoSuchElementException e) {
	            System.out.println("No such element found");
	        }
	    }



	public void createGifwithOverlay(String name) throws IOException, InterruptedException {

		createGifPage gif = new createGifPage();

		gif.sendGifname(name);

		gif.sendKeysOverlayField();

		gif.clickNextButton();
//		
		gif.clickonSaveButton();

		GifPage gifPage = new GifPage();

		gifPage.clickOnClosedGifWindow(name);
//		

	}

}
