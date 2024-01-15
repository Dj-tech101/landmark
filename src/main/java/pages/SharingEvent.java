package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class SharingEvent extends controlAction {

	// public static WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public SharingEvent() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//span[@class='selection']")
	private WebElement statusFiled;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement SearchFiled;
	
	@FindBy(xpath = "//span[@role='combobox']")
	private WebElement SearchUsernameFileds;

	@FindBy(xpath = "//input[@id='searchSharing']")
	private WebElement searchButton;
	
	public void searchStatus(String Name) {

		
		try {
			waitForElementToBeClickable(SearchUsernameFileds).click();

			waitForElementToBeVisible(SearchFiled).sendKeys(Name);
			Actions act = new Actions(driver);

			act.keyDown(Keys.ENTER).perform();

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", waitForElementToBeClickable(searchButton));

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@FindBy(xpath = "//panel[@class='datanote']")
	private WebElement noDataFoundMessage;
	
	
	public String getNoDataFoundMessage() {
		
		String text ="";
		
		try {
			text=waitForElementToBeVisible(noDataFoundMessage).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}
	
	
}
