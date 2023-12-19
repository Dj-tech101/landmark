package demo_testCases;

import java.io.IOException;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.TakescreenShotUtils;
import Utility.logger;
import pages.CheckoutPage;
import pages.PhotoPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class Create_Event_Basic_Configuration extends baseclass {

	// public WebDriver driver;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void ValidateGreenScreenButton_BasicEvent() throws InterruptedException, IOException {

		log = logger.getlogger();

		login = new loginpage(driver);

		log.info("login with valid credential");

		login.loginwithCredential("mahesh127@user.com", "Mahesh@123");

		creatEvent = new creatEventPage(driver);

		log.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);

		packageselect = new packagePage(driver);

		log.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails(driver);

		log.info("select month and pro options");

		packageDetails.selectPackage("MONTH", "Basic");

		eventDetails = new eventDetailsPage(driver);
		Random ran = new Random();

		int number = ran.nextInt();

		log.info("fill the event details");

		String name = "BasicEventTest" + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage(driver);

		log.info("drag Photo in Boothdesign");

		designPage.dragAndDropphotoNode();

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage(driver);

		Thread.sleep(1500);

		log.info("create single image photo");

		createPhotoPage createPhoto = new createPhotoPage(driver);

		photopage.clickonCreatePhotoButton();

		photopage.clickOnSingleImageButton();

		log.info("Validate the Toggele button For single Photo");

		TakescreenShotUtils.GetScreenShot(driver);

		org.testng.Assert.assertFalse(createPhoto.CheckedGreenScreenToggle());
		

	}
}
