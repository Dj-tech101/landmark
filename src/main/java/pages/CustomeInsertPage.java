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

public class CustomeInsertPage extends controlAction {

	// public static WebDriver driver;
	public WebDriverWait wait;

	public static JavascriptExecutor js;

	public CustomeInsertPage() {
		// TODO Auto-generated constructor stub

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[contains(text(),'Create New ')]")
	private WebElement createNewButton;

	public void clickOnCreateNewButton() {

		js = (JavascriptExecutor) driver;

		try {
			js.executeScript("arguments[0].click();", waitForElementToBeClickable(createNewButton));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "//div[@class='header']//*[name()='img']")
	WebElement closedPhotoButton;
	@FindBy(xpath = "//div[@class='name']")
	List<WebElement> nameOfMedia;

	public void clickOnClosedCustomeInsertWindow() throws IOException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));

		try {

			js = (JavascriptExecutor) driver;

			// Thread.sleep(1500);

			// Thread.sleep(Duration.ofSeconds(200));

			Thread.sleep(2000);

			//System.out.println("lets get name of photo");

			for (int i = 0; i < nameOfMedia.size(); i++) {

				System.out.println("size od the list is " + nameOfMedia.size());

				waitForElementToBeVisible(nameOfMedia.get(i));
				String actual = (nameOfMedia.get(i)).getText();

			//	System.out.println(actual);

				if (actual.contains("BETTA")) {
				//	System.out.println("ready to closed");
					js.executeScript("arguments[0].click();", waitForElementToBeClickable(closedPhotoButton));
					break;
				} else {

					clickOnClosedCustomeInsertWindow();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@FindBy(xpath = "//img[@class='trashimg' ]")
	List<WebElement> trashingElementList;

	public void deleteCustomeInsert() throws InterruptedException {
		int n = 0;

		Thread.sleep(1500);

		//System.out.println("name of the list is :" + nameOfMedia.size());
		//System.out.println("name of the list is :" + trashingElementList.size());

		try {
			for (int i = 0; i < nameOfMedia.size(); i++) {

				String value = waitForElementToBeVisible(nameOfMedia.get(i)).getText();
				//System.out.println("name of the elements is " + value);
				if (waitForElementToBeVisible(nameOfMedia.get(i)).getText().contains("BETTA")) {

					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", waitForElementToBeVisible(trashingElementList.get(i)));
					break;

				}
			}

		} catch (Exception e) {
			// TODO: handle exception.
			System.out.println(e.getMessage());
		}

	}

	public void CreateCuastomeInsertNode() throws IOException, InterruptedException {

		Thread.sleep(1000);

		CustomeInsertPage previewNode = new CustomeInsertPage();

		boothDesignPage designPage = new boothDesignPage();

		designPage.clickonCustomeInsertGearIcon();
		//previewNode.deleteCustomeInsert();

		previewNode.clickOnCreateNewButton();

		Runtime.getRuntime().exec("C:\\Users\\webca\\OneDrive\\Desktop\\QA\\createNewButton.exe");

		previewNode.clickOnClosedCustomeInsertWindow();

	}

}
