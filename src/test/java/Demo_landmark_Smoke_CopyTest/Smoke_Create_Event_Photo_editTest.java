package Demo_landmark_Smoke_CopyTest;

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

public class Smoke_Create_Event_Photo_editTest extends baseclass {

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
	
	public String EventnameUse;
//
	@Test(groups = "smoke",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Create_Event_Photo_copyTest() throws InterruptedException, IOException {

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

		int number = ran.nextInt();

		log.info("fill the event details");

		String EventnameUse = "Test paylater for photo " + String.valueOf(number);

		eventDetails.PaylaterFillNeccessoryDetailsForEvent(EventnameUse);
		designPage = new boothDesignPage();

		log.info("drag Gif in Boothdesign");

		
		//**************PHOTO NODE *****************
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
		
		myEvents.serachEventsAction(EventnameUse);

		
		

	}
	
	@Test(dependsOnMethods = "Create_Event_Photo_copyTest")
	public void validateCopyFunction() throws InterruptedException {
		log.info("copy button click");

		Random ran= new Random();
		
		
		String NeweventName="copyEvent"+EventnameUse+String.valueOf(ran.nextInt(120));
		myEvents.copyExistEvent(NeweventName);
		
		log.info("click on next button");

		packageselect.clickNextButton();
		
		log.info("foll date oonly");
		eventDetails.copyEventFillNeccessoryDetailsForEvent();
		
		designPage= new  boothDesignPage();
		
		designPage.clickNextButton();

		log.info("click on next button");
		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		log.info("fill the neccessory data ");

		checkoutPage.clickOnPayLaterButton();

		Thread.sleep(4000);
		
		
		log.info("Search Event ");


		myEvents.serachEventsAction(NeweventName);

		
		
		
		

	}
}
