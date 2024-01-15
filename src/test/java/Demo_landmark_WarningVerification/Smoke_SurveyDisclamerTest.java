package Demo_landmark_WarningVerification;

import java.io.IOException;

import java.util.Random;

import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.propertyFile;
import pages.PhotoPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;

public class Smoke_SurveyDisclamerTest extends baseclass {

	private loginpage login;
	private creatEventPage creatEvent;
	private packagePage packageselect;

	private packageDetails packageDetails;

	private eventDetailsPage eventDetails;

	private boothDesignPage designPage;



	private propertyFile pro;

	public Random ran;

	private String EventnameUse;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void WarnigMessagesurveyDisclamerTest() throws InterruptedException, IOException {

		// property use
		pro = new propertyFile();


		// login functionality

		login = new loginpage();

		extenttest.info("login with valid credential");

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

		createPhotoDesign(designPage);

		validatesurveyDisclamerWarning(designPage);
		
		designPage.clickNextButton();
		
		if (designPage.getWarningMessge().contains("Warning")) {

			org.testng.Assert.assertTrue(true);
			
		} else {
			org.testng.Assert.assertTrue(false);
		}

	}

//	private void reviewAndCheckoutPage() throws InterruptedException {
//		// TODO Auto-generated method stub
//		reviewPage = new pages.reviewPage();
//		reviewPage.clickNextButton();
//
//		CheckoutPage checkoutPage = new CheckoutPage();
//		log.info("Filling necessary checkout data");
//		checkoutPage.clickOnPayLaterButton();
//
//		Thread.sleep(4000);
//
//		myEvents = new MyEventsPage();
//		log.info("Searching for the event");
//		myEvents.serachEventsAction(EventnameUse);
//	}

//	private void createShareDesign(boothDesignPage designPage2) throws InterruptedException, IOException {
//		// TODO Auto-generated method stub
//		designPage.dragAndDropShare();
//
//		designPage.clickonShareGearIcon();
//
//		sharepage sharenode = new sharepage();
//
//		log.info("select the share options ");
//
//		sharenode.CreateNewShareNode("print");
//
//		designPage.clickNextButton();
//
//		log.info("click on next button");
//
//	}

	private void validatesurveyDisclamerWarning(boothDesignPage designPage2) throws InterruptedException {
		// TODO Auto-generated method stub
		extenttest.info("drag survey and Disclamer in Boothdesign");

		designPage.dragAndDropsurveyDisclamerNode();
	}


	private void createPhotoDesign(boothDesignPage designPage2) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		extenttest.info("drag Gif in Boothdesign");

		designPage.dragAndDropphotoNode();

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		extenttest.info("create new photo");

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		extenttest.info("select the new  photo template  options");

		photopage.createNewPhotoTemplate(nameofphoto);

	}

	private void fillEventDetails(eventDetailsPage eventDetails2) throws InterruptedException {
		ran = new Random();

		int number = ran.nextInt();

		extenttest.info("fill the event details");

		EventnameUse = "GifWarningTest" + String.valueOf(number);

		eventDetails.PaylaterFillNeccessoryDetailsForEvent(EventnameUse);

	}

	private void clickOncreateEventButton(creatEventPage creatEvent) throws InterruptedException {
		extenttest.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);
	}

	private void packageSelection(packagePage packageselect) throws InterruptedException {
		extenttest.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		extenttest.info("select month and pro options");

		packageDetails.selectPackage("PER EVENT", "Pro");

	}

}
