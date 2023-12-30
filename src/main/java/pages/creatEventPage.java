package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.controlAction;

public class creatEventPage extends controlAction {
	//public WebDriver driver;
	public WebDriverWait wait;

	public creatEventPage() {
		// TODO Auto-generated constructor stub

		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'CREATE NEW EVENT')]")
	WebElement creatEvent;

	public void clickoncreatEventButton() {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.visibilityOf(creatEvent)).click();
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
			
		}
		

	}

	public void HandleAlert() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		try {

			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (UnhandledAlertException e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@FindBy(id = "OkButton")
	WebElement okButton;
	
	@FindBy(id = "tooltippopup")
	WebElement frame;
	
	public void IframeHandle() {

//		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
//
//		driver.switchTo().frame(frame);
		

		wait.until(ExpectedConditions.visibilityOf(okButton)).click();
//		driver.switchTo().defaultContent();

	}

}
