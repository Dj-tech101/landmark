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

public class Smoke_Create_Event_Gif_Copy extends baseclass {

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
	

//groups = "smoke",retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class
	@Test()
	public void Validate_Creation_event_with_Gif_with_Paylater() throws InterruptedException, IOException {

		pro = new propertyFile();

		log = logger.getlogger();

		//controlAction.minimizeBrowser();
		login = new loginpage();

		log.info("login with valid credential");

		login.loginwithCredential(pro.getusername(), pro.getpassword());
		
//
//
		packageselect = new packagePage();
//
		eventDetails = new eventDetailsPage();
		log.info("Search Event ");

		myEvents = new MyEventsPage();
		
		EventnameUse="Test paylater for photo -2122472000";
		

		myEvents.serachEventsAction(EventnameUse);

		log.info("click on edit button");

	}

	@Test(dependsOnMethods = "Validate_Creation_event_with_Gif_with_Paylater")
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
