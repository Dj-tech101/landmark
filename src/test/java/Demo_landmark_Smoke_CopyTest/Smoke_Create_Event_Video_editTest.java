package Demo_landmark_Smoke_CopyTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.TakescreenShotUtils;
import Utility.logger;
import Utility.propertyFile;
import base.controlAction;
import dev.failsafe.internal.util.Assert;
import pages.CheckoutPage;
import pages.GifPage;
import pages.MyEventsPage;
import pages.PhotoPage;
import pages.VideoPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createGifPage;
import pages.createPhotoPage;
import pages.createVideoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class Smoke_Create_Event_Video_editTest extends baseclass {

	private loginpage login;
	private creatEventPage creatEvent;
	private packagePage packageselect;

	private packageDetails packageDetails;

	private eventDetailsPage eventDetails;

	private boothDesignPage designPage;

	private reviewPage reviewPage;

	private MyEventsPage myEvents;

	private Logger log;
	private propertyFile pro;

	public Random ran;

	private String EventnameUse;

//groups = "smoke",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class

	@Test()

	public void Create_Event_Video_EditTest() throws InterruptedException, IOException {

		// property use
		pro = new propertyFile();

		log = logger.getlogger();

		// login functionality

		login = new loginpage();

		log.info("login with valid credential");

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		// create event functionality
		creatEvent = new creatEventPage();

		clickOncreateEventButton(creatEvent);

		// package selection

		packageselect = new packagePage();
		packageSelection(packageselect);

		// Event details

		eventDetails = new eventDetailsPage();

		fillEventDetails(eventDetails);

		// **************PHOTO NODE *****************

		designPage = new boothDesignPage();

		designPage.createVideoNode();

		// ***********SHARE NODE*************

		createShareDesign(designPage);

		// Review page

		reviewAndCheckoutPage();

	}

	private void reviewAndCheckoutPage() throws InterruptedException {
		// TODO Auto-generated method stub
		reviewPage = new pages.reviewPage();
		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();
		log.info("Filling necessary checkout data");
		checkoutPage.clickOnPayLaterButton();

		Thread.sleep(4000);

		myEvents = new MyEventsPage();
		log.info("Searching for the event");
		myEvents.serachEventsAction(EventnameUse);
	}

	private void ClickonSaveButtonForCopy() throws InterruptedException {
		// TODO Auto-generated method stub
		reviewPage = new pages.reviewPage();
		reviewPage.clickNextButton();


		Thread.sleep(4000);

		myEvents = new MyEventsPage();
		log.info("Searching for the event");
		myEvents.serachEventsAction(EventnameUse);
	}
	private void createShareDesign(boothDesignPage designPage2) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		log.info("select the share options ");

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		log.info("click on next button");

	}

	private void fillEventDetails(eventDetailsPage eventDetails2) throws InterruptedException {
		ran = new Random();

		int number = ran.nextInt(20);

		log.info("fill the event details");

		EventnameUse = "video sample" + String.valueOf(number);

		eventDetails.PaylaterFillNeccessoryDetailsForEvent(EventnameUse);

	}

	private void clickOncreateEventButton(creatEventPage creatEvent) throws InterruptedException {
		log.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);
	}

	private void packageSelection(packagePage packageselect) throws InterruptedException {
		log.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		log.info("select month and pro options");

		packageDetails.selectPackage("PER EVENT", "Pro");

	}

	@Test(dependsOnMethods = "Create_Event_Video_EditTest",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)
	public void validateCopyFunction() throws InterruptedException {

		log.info("Copy button click");

		Random ran = new Random();
		String newEventName = "copyEvent" + EventnameUse + String.valueOf(ran.nextInt(120));
		myEvents.copyExistEvent(newEventName);

		packageselect.clickNextButton();
		eventDetails.copyEventFillNeccessoryDetailsForEvent();

		designPage = new boothDesignPage();
		designPage.clickNextButton();

		ClickonSaveButtonForCopy();
	}
}
