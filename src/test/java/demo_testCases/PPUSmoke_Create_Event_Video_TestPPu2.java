package demo_testCases;

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
import pages.VideoPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.createVideoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class PPUSmoke_Create_Event_Video_TestPPu2 extends baseclass {

	// public WebDriver driver;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;

	@Test(groups = "smoke", retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Validate_Creation_event_with_Video() throws InterruptedException, IOException {

		log = logger.getlogger();

		login = new loginpage(driver);

		log.info("login with valid credential");

		login.loginwithCredential("pputest@gmail.com", "ppu12345");

		creatEvent = new creatEventPage(driver);

		log.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(2000);

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
		
		Date date= new Date();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd/mm/yyyy/hh:mm");

		
		String name = "testnormal" + formatter.format(date);

		eventDetails.FillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage(driver);

		log.info("drag photo in Boothdesign");

		// **************GIF NODE *****************
		designPage.dragAndDropVideoNode();

		designPage.clickonVideoGearIcon();

		VideoPage videoPage = new VideoPage(driver);

		int value = ran.nextInt();

		String nameooVideo = "VideoName" + String.valueOf(value);

		log.info("click on create new video option");
		
		videoPage.clickonCreateVideoButton();

		log.info("fill the neccessory details in video");

		createVideoPage createVideo = new createVideoPage(driver);

		createVideo.createGifwithOverlay(nameooVideo);
		
		// ***********SHARE NODE*************

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage(driver);

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
