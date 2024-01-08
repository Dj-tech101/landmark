package Demo_landmark_Smoke_EventType;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.logger;
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

public class Smoke_Create_Event_WithGreenScreen extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	
	public propertyFile pro;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class,groups = "smoke")

	public void GreenscreenTest() throws InterruptedException, IOException {

		
		pro= new propertyFile();
		

		login = new loginpage();

		extenttest.info("login with valid credential");

		login.loginwithCredential(pro.getusername(),pro.getpassword());

		creatEvent = new creatEventPage();

		extenttest.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);

		packageselect = new packagePage();

		extenttest.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		extenttest.info("select month and pro options");

		packageDetails.selectPackage("MONTH", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();

		extenttest.info("fill the event details");

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

		extenttest.info("drag Photo in Boothdesign");

		designPage.dragAndDropphotoNode();

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);


		extenttest.info("create new photo");

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		extenttest.info("select the new single photo options");

		photopage.createNewSinglePhoto(nameofphoto);


		extenttest.info("drag the share options ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();


		extenttest.info("select the share options ");

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		extenttest.info("click on next button");
		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		extenttest.info("fill the neccessory data ");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		extenttest.info("assser the valid data for new  event ");
		org.testng.Assert.assertTrue(true);
		
		extenttest.info("Event is created ");

	}
}
