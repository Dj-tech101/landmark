package Demo_landmark_Sharing_TestCases;

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

public class Smoke_Create_PerEventGIF_Basic_Smugmug2 extends baseclass {

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
	
	
	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Smoke_Create_PerEventGIF_Basic_() throws InterruptedException, IOException {

		pro= new propertyFile();
		
		log = logger.getlogger();

		log.info("login with valid credential");
		login = new loginpage();

		login.loginwithCredential(pro.getusername() ,pro.getpassword());

		creatEvent = new creatEventPage();

		log.info("click on create new event button");

		creatEvent.clickoncreatEventButton();
		Thread.sleep(2000);

		packageselect = new packagePage();

		log.info("click on package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();
		
		log.info("select package");


		packageDetails.selectPackage("PER EVENT", "Basic");


		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();
		String name = "TestGIF_smugShare" + String.valueOf(number);

		log.info("fill necccessory data");

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage();

		
		
		
		
		
		//************ PHTOT NODE***************88
		designPage.dragAndDropGifNode();

		designPage.clickonGifGearIcon();

		GifPage gifPage = new GifPage();

		//Thread.sleep(1500);



		int value = ran.nextInt();

		String nameofGif = "gifName" + String.valueOf(value);

		log.info("click on create new gif option");
		
		gifPage.clickonCreateGifButton();

		log.info("fill the neccessory details in gif");

		createGifPage createGif = new createGifPage();

		createGif.createGifwithOverlay(nameofGif);
		
		
		
		
		
		
		//************ SHARE NODE***************
		

		log.info("create Sahre node ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();


		sharepage sharenode = new sharepage();

		sharenode.CreateNewShareNode("print");

	//	sharenode.CreateNewShareNodemore("email", "smugmug");


		log.info("click on next button");

		designPage.clickNextButton();

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		log.info("fill credit details");
		
		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");

	}
}
