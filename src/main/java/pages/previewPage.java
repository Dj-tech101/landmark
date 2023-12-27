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
import base.controlAction;

public class previewPage extends controlAction {

	//public static WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public previewPage() {
		// TODO Auto-generated constructor stub

		///.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//input[@role='switch']")
	private WebElement previewToggle;
	
	public void clickonPreviewSwitch() {


		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(previewToggle));

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}
	
	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedPhotoButton;

	public void clickOnClosedPreviewWindow() throws IOException {

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
	
	public void CreatePreviewNode() throws IOException, InterruptedException {

		Thread.sleep(1000);
		
		previewPage previewNode = new previewPage();

		boothDesignPage designPage = new boothDesignPage();

		designPage.clickonShareGearIcon();

		previewNode.clickonPreviewSwitch();
		
		previewNode.clickOnClosedPreviewWindow();

	}

	
}
