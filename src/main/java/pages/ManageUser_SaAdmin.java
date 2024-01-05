package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
import io.netty.handler.timeout.TimeoutException;

public class ManageUser_SaAdmin extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public ManageUser_SaAdmin() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tr[@class='#3C444C']/td")
	private List<WebElement> userInformation;

	public List<String> getInformationOfUser() throws InterruptedException {

		List<String> info = new ArrayList<String>();

		try {
			for (WebElement element : userInformation) {

				Thread.sleep(1500);
				info.add(waitForElementToBeVisible(element).getText());
			}
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

		return info;

	}

	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement viewButton;

	public void clickOnViewButton() {

		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(100,0)", "");

		js.executeScript("arguments[0].click();", waitForElementToBeVisible(viewButton));

	}
	
	
	@FindBy(xpath = "//h1[@class='useremail']")
	private WebElement userEmail;
	
	public String getIUserEmailText() {
		
		return waitForElementToBeVisible(userEmail).getText();
	}
}
