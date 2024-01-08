package Demo_landmark_Smoke_EditsEvent;

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
//groups = "smoke",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class
	@Test()

	public void Create_Event_Video_EditTest() throws InterruptedException, IOException {

		pro= new propertyFile();
		
		log = logger.getlogger();

		login = new loginpage();

		extenttest.info("login with valid credential");

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		extenttest.info("click on create event button");

		creatEvent.clickoncreatEventButton();

		Thread.sleep(3000);

		packageselect = new packagePage();

		extenttest.info("select the package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		extenttest.info("select month and pro options");

		packageDetails.selectPackage("PER EVENT", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();

		extenttest.info("fill the event details");

		String name = "Test paylater for video " + String.valueOf(number);

		eventDetails.PaylaterFillNeccessoryDetailsForEvent(name);
		designPage = new boothDesignPage();

		extenttest.info("drag Gif in Boothdesign");

		
		//**************VIDEO NODE *****************
		
		designPage.createVideoNode();
		
		//***********SHARE NODE*************
		
		
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

		checkoutPage.clickOnPayLaterButton();

		Thread.sleep(4000);
		
		extenttest.info("Search Event ");
		
		myEvents =new MyEventsPage();
		
		myEvents.serachEventsAction(name);

		extenttest.info("click on edit button");
		
		myEvents.clickOnEditButton();
		
		controlAction.takeScreenshot("test video edit event");
		
		org.testng.Assert.assertEquals("Video", designPage.getVideoNodeText());

	}
}
