package Demo_landmark_Smoke_EventType;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.propertyFile;
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

public class Smoke_Create_PerMonth_Pro extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;
	public propertyFile pro;
	


	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)


	public void validate_Per_MonthCreaton () throws InterruptedException, IOException {

		
		pro= new propertyFile();
		
		login = new loginpage();

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		creatEvent.clickoncreatEventButton();
//
//		
		Thread.sleep(3000);

		packageselect = new packagePage();

		packageselect.clickOnPackage();

		System.out.println("click on new package button");

		// packageselect.clickonnewPackageButton();

		packageDetails = new packageDetails();

		packageDetails.selectPackage("PER MONTH", "Pro");

		System.out.println("fill the neccessory details");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();
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
		designPage = new boothDesignPage();

		System.out.println("drag photo to destination");
		designPage.dragAndDropphotoNode();

		System.out.println("click on phto gear icon ");

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		// photopage.clickonCreatePhotoButton();

		// photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);
		photopage.createNewSinglePhoto(nameofphoto);

//		createPhoto.sendNameTextField(nameofphoto);
//
//		createPhoto.sendKeysOverlayField();
//
//		createPhoto.clickonSaveButton();
//
//		photopage.clickOnClosedPhotoWindow(nameofphoto);

		System.out.println("closed the window ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		System.out.println("lets click on share gear icon");

		sharepage sharenode = new sharepage();

//		sharenode.getlistofshareOptions("print");
//
//		sharenode.clickonPrintSwitch();
//
//		sharenode.clickOnClosedPhotoWindow();

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");


	
	}}
