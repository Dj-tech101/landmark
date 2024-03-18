package pages;

import java.beans.DesignMode;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class GifPage extends controlAction {

	// public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public GifPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(),'Create New')]")

	WebElement createGifButton;

	public void clickonCreateGifButton() throws InterruptedException {

		Thread.sleep(500);

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", waitForElementToBeClickable(createGifButton));

		// e1.click();
//		Actions act = new Actions(driver);
//		act.click(e1).perform();

	}

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedGifButton;

	@FindBy(xpath = "//div[@class='name']")
	List<WebElement> listofthephotos;
	@FindBy(xpath = "(//div[@class='gif-holder'])[8]/div/div/img")
	private WebElement imageTag1;

	@FindBy(xpath ="//div[@class='scroller']/div/div[1]")
	private WebElement loaderEelement;

	
	public void clickOnClosedGifWindow(String expectedname) throws InterruptedException {
		
			
			Thread.sleep(15000);
			String border=loaderEelement.getCssValue("border");
			
			System.out.println(border);
		
		
		
		
		if (border.contains("2.4px solid rgb(91, 62, 238)")) {

			for (int i = 0; i < listofthephotos.size(); i++) {
				
				String actualPhotoname = listofthephotos.get(i).getText();

				System.out.println(actualPhotoname);

				if (actualPhotoname.equalsIgnoreCase(expectedname)) {

					//System.out.println("Iam enter in the loop");
					
					js = (JavascriptExecutor) driver;


					js.executeScript("arguments[0].click();", waitForElementToBeVisible(closedGifButton));

					break;
				} else {

					System.out.println("element is not display ");
				}
			}
		}
		
		
	}

}
