package pages;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.logger;
import Utility.propertyFile;
import base.controlAction;

public class boothDesignPage extends controlAction {
	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public MyEventsPage myEvents;
	
	public Logger log;
	public propertyFile pro;

//	public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public boothDesignPage() {
		// TODO Auto-generated constructor stub

//		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "btnValidateDesign")
	WebElement nextButton;

	public void clickNextButton() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));

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

	public void dragAndDropphotoNode() {

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(photoNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "//img[@id='img-tool-share']")
	WebElement sharesource;

	public void dragAndDropShare() throws InterruptedException {

		Thread.sleep(3000);
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

			Actions act = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

			WebElement source = wait.until(ExpectedConditions.visibilityOf(sharesource));
			WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

			act.dragAndDrop(source, dest).build().perform();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());

		}

	}

	@FindBy(xpath = "(//mat-icon[contains(text(),'add')])[3]")

	WebElement gifNode;

	public void dragAndDropGifNode() {

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(gifNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "//*[@id='graphContainer']//*[name()='svg']//*[name()='g'][3]//*[name()='g'][3]//*[name()='image']")
	WebElement gearIcon;

//	public void clickonCustomeInsertGearIcon() {
//
//		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//
//		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(gearIcon));
//
//		
//		js = (JavascriptExecutor) driver;
//		try {
//
//			// js.executeScript("arguments[0].click();", gear);
//
//			Actions act = new Actions(driver);
//
//			act.moveToElement(gearIcon).click().perform();
//		} catch (NoSuchElementException e) {
//			// TODO: handle exception
//		}
//
//	}

	@FindBy(xpath = "//*[@id='graphContainer']//*[name()='svg']//*[name()='g'][3]//*[name()='g'][2]//*[name()='image']")
	WebElement photoGearIcon;

	public void clickonPhotoGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(photoGearIcon));

		js = (JavascriptExecutor) driver;
		try {

			Actions act = new Actions(driver);
			act.click(gear).perform();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void clickonShareGearIcon() throws InterruptedException {

		// wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		js = (JavascriptExecutor) driver;
		try {

			// js.executeScript("arguments[0].click();",
			// waitForElementToBeClickable(gearIcon));

			Actions act = new Actions(driver);
			Thread.sleep(300);

			act.moveToElement(waitForElementToBeClickable(gearIcon)).click().perform();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	public void clickonCustomeInsertGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(gearIcon));

		js = (JavascriptExecutor) driver;
		try {

			// js.executeScript("arguments[0].click();", gear);

			Actions act = new Actions(driver);

			act.moveToElement(gearIcon).click().perform();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	public void clickonGifGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

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

	@FindBy(xpath = "(//mat-icon[contains(text(),'add')])[2]")

	WebElement VideoNode;

	public void dragAndDropVideoNode() {

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(VideoNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	public void clickonVideoGearIcon() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(photoGearIcon));

		js = (JavascriptExecutor) driver;
		try {

			Actions act = new Actions(driver);
			act.click(gear).perform();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	@FindBy(xpath = "//img[@id='img-tool-preview']")
	WebElement previewsource;

	public void dragAndDropPreview() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(previewsource));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "//img[@id='img-tool-custom-insert']")
	private WebElement CustomeInsertNode;

	public void dragAndDropCustomeInsertNode() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(CustomeInsertNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}

	@FindBy(xpath = "(//span[contains(text(),'GIF')])[2]")
	private WebElement GifNodeText;

	public String getGifNodeText() {

		return waitForElementToBeVisible(GifNodeText).getText();

	}

	@FindBy(xpath = "(//span[contains(text(),'Photo')])[2]")
	private WebElement PHOTONodeText;

	public String getPhotoNodeText() {

		return waitForElementToBeVisible(PHOTONodeText).getText();

	}

	@FindBy(xpath = "(//span[contains(text(),'Video')])[2]")
	private WebElement VideoNodeText;

	public String getVideoNodeText() {

		return waitForElementToBeVisible(VideoNodeText).getText();

	}

	public void createVideoNode() throws InterruptedException, IOException {
		designPage= new boothDesignPage();
		
		log=logger.getlogger();
		
		designPage.dragAndDropVideoNode();

		designPage.clickonVideoGearIcon();

		VideoPage videoPage = new VideoPage();

		Random ran= new Random();
		
		int value = ran.nextInt();

		String nameooVideo = "VideoName" + String.valueOf(value);

		log.info("click on create new video option");
		
		videoPage.clickonCreateVideoButton();

		log.info("fill the neccessory details in video");

		createVideoPage createVideo = new createVideoPage();

		createVideo.createGifwithOverlay(nameooVideo);
		
	}
	public void createVideoNodeForBackGround(String type) throws InterruptedException, IOException {
		designPage= new boothDesignPage();
		
		log=logger.getlogger();
		
		designPage.dragAndDropVideoNode();

		designPage.clickonVideoGearIcon();

		VideoPage videoPage = new VideoPage();

		Random ran= new Random();
		
		int value = ran.nextInt();

		String nameooVideo = "VideoName" + String.valueOf(value);

		log.info("click on create new video option");
		
		videoPage.clickonCreateVideoButton();

		log.info("fill the neccessory details in video");

		createVideoPage createVideo = new createVideoPage();

		createVideo.createNewVideoWithoutBackground(nameooVideo, type);
		
	}
	
	
	@FindBy(xpath = "//div[@class='header']/span")
	private WebElement warningMessage;
	
	public String getWarningMessge() {
		
		String text="";
		
		
		try {
			
			text=waitForElementToBeVisible(warningMessage).getText();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
		
	}
	
	
	@FindBy(xpath = "//img[@id='img-tool-survey']")
	private WebElement surveyDisclamer;

	public void dragAndDropsurveyDisclamerNode() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(surveyDisclamer));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}
	
	@FindBy(xpath = "//img[@id='img-tool-edit']")
	private WebElement EditNode;

	public void dragAndDropEditNode() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(EditNode));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}
	
	@FindBy(xpath = "//img[@id='img-tool-age-gate']")
	private WebElement AgeGate;

	public void dragAndDropAgeGateNode() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement source = wait.until(ExpectedConditions.visibilityOf(AgeGate));
		WebElement dest = wait.until(ExpectedConditions.visibilityOf(destination));

		act.dragAndDrop(source, dest).build().perform();
	}
}
