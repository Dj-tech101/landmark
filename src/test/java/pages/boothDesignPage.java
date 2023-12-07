package pages;

import java.beans.DesignMode;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class boothDesignPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public boothDesignPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "btnValidateDesign")
	WebElement nextButton;

	public void clickNextButton() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(nextButton));
		;

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", e1);

	}

	@FindBy(xpath = "(//mat-icon[contains(text(),'add')])[1]")
	WebElement photoNode;

	@FindBy(xpath = "//div[@id='graphContainer']")
	WebElement destination;

	public void dragAndDrop() {

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(photoNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "//img[@id='img-tool-share']")
	WebElement sharesource;

	public void dragAndDropShare() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(sharesource));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "//*[@id='graphContainer']//*[name()='svg']//*[name()='g'][3]//*[name()='g'][3]//*[name()='image']")
	WebElement gearIcon;

	public void clickonShareGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(gearIcon));

		js = (JavascriptExecutor) driver;
		try {

			Actions act = new Actions(driver);
			act.click(gear).perform();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	@FindBy(xpath = "//*[@id='graphContainer']//*[name()='svg']//*[name()='g'][3]//*[name()='g'][2]//*[name()='image']")
	WebElement photoGearIcon;

	public void clickonPhotoGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(photoGearIcon));

		js = (JavascriptExecutor) driver;
		try {

			Actions act = new Actions(driver);
			act.click(gear).perform();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	@FindBy(xpath = "//*[@id='graphContainer']//*[name()='div']//*[name()='span']")
	List<WebElement> listofNodes;

	public void getlistoftheNodes() {

		for (WebElement list : listofNodes) {

			String actual = list.getText();

			if (actual.equalsIgnoreCase("Start")) {

			}
		}
	}

}
