package demo_testCases;

import java.io.IOException;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import pages.CheckoutPage;
import pages.MyEventsPage;
import pages.PhotoPage;
import pages.RegistrationPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class Create_Event_NewFresh extends baseclass {

	// public WebDriver driver;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	@Test()

	public void TestNewUserCreation() throws InterruptedException, IOException {

		RegistrationPage reg = new RegistrationPage(driver);
		String pass = reg.createNewUser();

		login = new loginpage(driver);

		login.loginForNewreg(pass);

		creatEvent = new creatEventPage(driver);

		creatEvent.clickoncreatEventButton();

		creatEvent.IframeHandle();

		Thread.sleep(3000);

		packageselect = new packagePage(driver);

		// packageselect.clickOnPackage();

		System.out.println("click on new package button");

		// packageselect.clickonnewPackageButton();

		packageDetails = new packageDetails(driver);

		packageDetails.selectPackage("MONTH", "Pro");

		System.out.println("fill the neccessory details");

		eventDetails = new eventDetailsPage(driver);
		Random ran = new Random();

		int number = ran.nextInt();
		String name = "TESTAUTOMATION" + String.valueOf(number);

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

		System.out.println("drag photo to destination");
		designPage.dragAndDropphotoNode();

		System.out.println("click on phto gear icon ");

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage(driver);

		Thread.sleep(1500);

		// photopage.clickonCreatePhotoButton();

		// photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage(driver);

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

		sharepage sharenode = new sharepage(driver);

//		sharenode.getlistofshareOptions("print");
//
//		sharenode.clickonPrintSwitch();
//
//		sharenode.clickOnClosedPhotoWindow();

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		reviewPage = new reviewPage(driver);

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.FillNeccessoryCardDetails("New");

		MyEventsPage myEvents = new MyEventsPage(driver);

		String actualName = myEvents.GetEventName();

		Assert.assertEquals(actualName, name);

		System.err.println("Event is created ");

	}
}
