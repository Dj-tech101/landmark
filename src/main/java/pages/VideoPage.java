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

public class VideoPage extends controlAction{

	//public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public VideoPage() {
		// TODO Auto-generated constructor stub

	//	this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(),'Create New')]")

	WebElement createVideoButton;

	public void clickonCreateVideoButton() throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(createVideoButton));

		Thread.sleep(500);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e1);

		// e1.click();
//		Actions act = new Actions(driver);
//		act.click(e1).perform();

	}

	
	

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedGifButton;
	

	@FindBy(xpath = "//div[@class='name']")
	List<WebElement> listofthephotos;

	public void clickOnClosedGifWindow(String expectedname) throws InterruptedException {

	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		Thread.sleep(2500);

		for (WebElement elements : listofthephotos) {

			String actualPhotoname = elements.getText();
			

			if (actualPhotoname.equalsIgnoreCase(expectedname)) {

//				 Wait<WebDriver> wait = new FluentWait<>(driver)
//			                .withTimeout(Duration.ofSeconds(1500))
//			                .pollingEvery(Duration.ofSeconds(1500))
//			                .ignoring(Exception.class); // Ignore exceptions for more robustness

				js = (JavascriptExecutor) driver;

				WebElement element = wait.until(ExpectedConditions.visibilityOf(closedGifButton));

				js.executeScript("arguments[0].click();", element);

				break;

			}
		}}
	
}
