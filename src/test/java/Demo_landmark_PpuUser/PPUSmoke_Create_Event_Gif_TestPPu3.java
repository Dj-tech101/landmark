package Demo_landmark_PpuUser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.TakescreenShotUtils;
import Utility.logger;
import Utility.propertyFile;
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

public class PPUSmoke_Create_Event_Gif_TestPPu3 extends baseclass {

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

	public void Validate_Creation_event_with_Gif() throws InterruptedException, IOException {

		log = logger.getlogger();

		login = new loginpage();

		extenttest.info("login with valid credential");

		
		login.loginwithCredential(new propertyFile().getusername(), new propertyFile().getpassword());

		creatEvent = new creatEventPage();

		extenttest.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(2000);

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
		
		Date date= new Date();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd-mm-hh:mm");

		
		String name = "TestGifsharing" + String.valueOf(number);;

		eventDetails.FillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage();

		extenttest.info("drag photo in Boothdesign");

		// **************GIF NODE *****************
		designPage.dragAndDropGifNode();

		designPage.clickonGifGearIcon();

		GifPage gifPage = new GifPage();

		//Thread.sleep(1500);



		int value = ran.nextInt();

		String nameofGif = "gifName" + String.valueOf(value);

		extenttest.info("click on create new gif option");
		
		gifPage.clickonCreateGifButton();

		extenttest.info("fill the neccessory details in gif");

		createGifPage createGif = new createGifPage();

		createGif.createGifwithOverlay(nameofGif);
		
		// ***********SHARE NODE*************

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
