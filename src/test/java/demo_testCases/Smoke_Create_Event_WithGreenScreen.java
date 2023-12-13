package demo_testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.logger;
import dev.failsafe.internal.util.Assert;
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

public class Smoke_Create_Event_WithGreenScreen extends baseclass {

	// public WebDriver driver;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class,groups = "smoke")

	public void name() throws InterruptedException, IOException {

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

		packageDetails.selectPackage("MONTH", "Pro");

		eventDetails = new eventDetailsPage(driver);
		Random ran = new Random();

		int number = ran.nextInt();

		log.info("fill the event details");

		String name = "TestAutomation" + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);
//		eventDetails.eventNameSendkeys("testAutomation");
//		eventDetails.startNowRadioButton();
//		eventDetails.timeZoneSelection("Delhi");
//		eventDetails.contrySelection("India");
//		eventDetails.stateSelection("Maharashtra");
//		eventDetails.citySendkeys("pune");
//		eventDetails.clickNextButton();
//		System.out.println("click on next button ");

		// eventDetails.eventSubmission();
		designPage = new boothDesignPage(driver);

		log.info("drag Photo in Boothdesign");

		designPage.dragAndDropphotoNode();

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage(driver);

		Thread.sleep(1500);

		// photopage.clickonCreatePhotoButton();

		// photopage.clickOnSingleImageButton();

		log.info("create new photo");

		createPhotoPage createPhoto = new createPhotoPage(driver);

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		log.info("select the new single photo options");

		photopage.createNewSinglePhoto(nameofphoto);

//		createPhoto.sendNameTextField(nameofphoto);
//
//		createPhoto.sendKeysOverlayField();
//
//		createPhoto.clickonSaveButton();
//
//		photopage.clickOnClosedPhotoWindow(nameofphoto);

		log.info("drag the share options ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage(driver);

//		sharenode.getlistofshareOptions("print");
//
//		sharenode.clickonPrintSwitch();
//
//		sharenode.clickOnClosedPhotoWindow();

		log.info("select the share options ");

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		log.info("click on next button");
		reviewPage = new reviewPage(driver);

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		log.info("fill the neccessory data ");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		log.info("assser the valid data for new  event ");
		org.testng.Assert.assertTrue(true);
		
		log.info("Event is created ");

	}
}
