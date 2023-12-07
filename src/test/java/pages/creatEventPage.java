package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class creatEventPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public creatEventPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'CREATE NEW EVENT')]")
	WebElement creatEvent;

	public void clickoncreatEventButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(creatEvent)).click();
		;

	}

	public void HandleAlert() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(5));

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
