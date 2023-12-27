package Demo_landmark_Smoke_CreatePhoto;

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
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createGifPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class Smoke_Create_Event_Photo_Test_WithPaylater2 extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public MyEventsPage myEvents;
	
	public Logger log;
	public propertyFile pro;
//
	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Validate_Creation_event_with_Gif_with_Paylater() throws InterruptedException, IOException {

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

		packageDetails.selectPackage("PER EVENT", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt(123);

		log.info("fill the event details");

		String name = "Test paylater function with Photo " + String.valueOf(number);

		eventDetails.PaylaterFillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage();

		log.info("drag Gif in Boothdesign");

		
		//**************PHOTO  NODE *****************
		
		designPage.dragAndDropphotoNode();

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		log.info("create new photo");

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		log.info("select the new  photo template  options");

		photopage.createNewPhotoTemplate(nameofphoto);
		

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

		checkoutPage.clickOnPayLaterButton();

		Thread.sleep(4000);
		
		log.info("Search Event ");
		
		myEvents =new MyEventsPage();
		
		myEvents.serachEventsAction(name);

		log.info("assser the valid data for new  event ");

		String expectedText ="GO LIVE";
		
		String actualText=myEvents.getGoLiveButtontext();
		
		System.out.println(actualText);
		
		if (expectedText.contains(actualText)) {
			assertTrue(true);
		}
		else {
			controlAction.takeScreenshot("goLiveButtontest");
			assertTrue(false);
		}

	}
}
