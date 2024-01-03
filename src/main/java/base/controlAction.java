package base;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Utility.propertyFile;

public abstract class controlAction {
	protected static WebDriver driver;
	private static propertyFile propOperations;
	private static WebDriverWait wait;

	static public void launchBrowser() throws IOException {
		propOperations = new propertyFile();

		// System.setProperty(ConstantPath.CHROME_DRIVER_KEY,
		// ConstantPath.CHROME_DRIVER_VALUE);
		driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();

		long timeoutInSeconds = 30;
		long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeoutInSeconds);

		// Retry until the URL is loaded or timeout is reached
		while (System.currentTimeMillis() < endTime) {
			try {
				// Attempt to navigate to the URL
				driver.get(propOperations.getUrl());

				// Check if a condition indicating a successful load is met
				if (driver.getCurrentUrl().contains("photopartyupload.com/Account/LogOnFromUser")) {
					System.out.println("Page loaded successfully.");
					break; // Break out of the loop if successful
				}

				// Sleep for a short interval before retrying
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				// Handle exceptions, if needed
				e.printStackTrace();
			}
		}

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	}

	protected void setText() {

	}

	public static void closeBrowser() {

		driver.close();

	}

	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = null;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				e = driver.findElement(By.xpath(locatorValue));
			break;

		case "CSS":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				e = driver.findElement(By.cssSelector(locatorValue));
			break;

		case "ID":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			else
				e = driver.findElement(By.id(locatorValue));
			break;

		case "NAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			else
				e = driver.findElement(By.name(locatorValue));
			break;

		case "LINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			else
				e = driver.findElement(By.linkText(locatorValue));
			break;

		case "PARTIALLINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			else
				e = driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "CLASSNAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			else
				e = driver.findElement(By.className(locatorValue));
			break;

		case "TAGNAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			else
				e = driver.findElement(By.tagName(locatorValue));
			break;

		default:
			System.out.println("Locator is invalid");
		}

		return e;
	}

	protected WebElement waituntillFullPageloaded(WebElement element) {

//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(5))
//				.pollingEvery(Duration.ofSeconds(150)).withMessage("loaded successfully");

		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	protected WebElement waitForElementToBeVisible(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e));
	}

	protected WebElement waitForElementToBeClickable(WebElement e) {
		return wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	protected void waitForElementToBeInvisible(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		try {
			wait.until(ExpectedConditions.invisibilityOf(e));
		} catch (NoSuchElementException ne) {
			System.out.println(ne.getMessage());
		} catch (TimeoutException te) {
			System.out.println(te.getMessage());
		}
	}

	protected boolean isElementDisplayed(WebElement e) {
		try {
			return e.isDisplayed();
		} catch (NoSuchElementException ne) {
			return false;
		}
	}

	protected boolean isElementDisplayedWithWait(WebElement e) {
		try {
			wait.until(ExpectedConditions.visibilityOf(e));
			return true;
		} catch (NoSuchElementException ne) {
			return false;
		}
	}

	protected boolean isElementDisplayedWithWait(WebElement e, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			wait.until(ExpectedConditions.visibilityOf(e));
			return true;
		} catch (Exception ne) {
			return false;
		}
	}

	
	
	protected static void waitUntillVsibilityOfAllElement(List<WebElement>listogele) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(listogele));
	}
   public static void minimizeBrowser() {
		
		driver.manage().window().minimize();
	}
	public static void takeScreenshot(String fileName) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Date date = new Date();

			SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
			String dateFormate = formatter.format(date);

			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\screen\\" + fileName+dateFormate + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected List<String> getElementTextList(List<WebElement> listOfWebElements) {
		List<String> listOfElementText = new ArrayList<String>();
		for (WebElement element : listOfWebElements) {
			listOfElementText.add(element.getText());
		}
		return listOfElementText;
	}

	protected void clickOnElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		/*
		 * WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		 * e.click();
		 */
		clickOnElement(locatorType, locatorValue, isWaitRequired, false);
	}

	protected void clickOnElement(String locatorType, String locatorValue, boolean isWaitRequired,
			boolean isWaitRequiredBeforeClick) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		if (isWaitRequiredBeforeClick) {
			waitForElementToBeClickable(e);
		}
		e.click();
	}

	protected void clickOnElement(WebElement element, boolean isWaitRequired) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected String getElementText(String locatorType, String locatorValue, boolean isWaitRequired) {
		return getElement(locatorType, locatorValue, isWaitRequired).getText();
	}

	protected String getElementText(WebElement e, boolean isWaitRequired) {
		if (isWaitRequired)
			waitForElementToBeVisible(e);
		return e.getText();
	}
	
	
}
