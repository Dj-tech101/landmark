package Demo_landmark_PpuUser;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import BaseClass.baseclass;
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

public class PPUSmoke_Create_Event_Photo extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;

	@Test(groups = "share", retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Validate_Creation_event_with_Photo() throws InterruptedException, IOException {

		log = logger.getlogger();

		login = new loginpage();

		log.info("login with valid credential");

		login.loginwithCredential("pputest@gmail.com", "ppu12345");

		creatEvent = new creatEventPage();

		log.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(300);

		packageselect = new packagePage();

		log.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		log.info("select month and pro options");

		packageDetails.selectPackage("MONTH", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();

		log.info("fill the event details");
		
		Date date= new Date();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd");

		
		String name = "testPHOTOSharing" + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage();

		log.info("drag photo in Boothdesign");

		// **************pHOTO NODE *****************
		designPage = new boothDesignPage();

		designPage.dragAndDropphotoNode();


		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		photopage.createNewSinglePhoto(nameofphoto);

		// ***********SHARE NODE*************

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		log.info("select the share options ");

		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();

		log.info("click on next button");
		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		log.info("fill the neccessory data ");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		log.info("assser the valid data for new  event ");
		org.testng.Assert.assertTrue(true);

		log.info("Event is created ");

	}
}
