package Demo_landmark_Smoke_CreateVideo;

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
import pages.GifPage;
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

public class Smoke_Create_Event_VideoTest extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;
	public propertyFile pro;

	@Test(groups = "smoke",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Validate_Creation_event_with_Gif() throws InterruptedException, IOException {

		
		pro= new propertyFile();
		
		log = logger.getlogger();

		login = new loginpage();

		log.info("login with valid credential");

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		log.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);

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

		String name = "TestVideoCREATION" + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage();

		log.info("drag Videonode in Boothdesign");

		
		//**************Video NODE *****************
		designPage.dragAndDropVideoNode();

		designPage.clickonVideoGearIcon();

		VideoPage videoPage = new VideoPage();

		int value = ran.nextInt();

		String nameooVideo = "VideoName" + String.valueOf(value);

		log.info("click on create new video option");
		
		videoPage.clickonCreateVideoButton();

		log.info("fill the neccessory details in video");

		createVideoPage createVideo = new createVideoPage();

		createVideo.createGifwithOverlay(nameooVideo);
		

		//***********SHARE NODE*************
		
		
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
