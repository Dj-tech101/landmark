package Demo_landmark_Smoke_EventType;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
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

public class Smoke_Create_PerMonth_Pro extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;
	public propertyFile pro;
	


	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)


	public void validate_Per_MonthCreaton () throws InterruptedException, IOException {


		pro= new propertyFile();
		
		login = new loginpage();

		extenttest.info("login with valid crendential");
		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		creatEvent.clickoncreatEventButton();
		Thread.sleep(3000);

		packageselect = new packagePage();

		packageselect.clickOnPackage();

   
		extenttest.info("click on new package button");
		// packageselect.clickonnewPackageButton();

		packageDetails = new packageDetails();

		packageDetails.selectPackage("PER MONTH", "Pro");

        extenttest.info("fill the neccessory details");
        
		eventDetails = new eventDetailsPage();
		Random ran = new Random(100);

		int number = ran.nextInt();
		String name = "PER EVETN TEST " + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);

		// eventDetails.eventSubmission();
		designPage = new boothDesignPage();

		extenttest.info("drag photo to destination");
		
		designPage.dragAndDropphotoNode();


		extenttest.info("click on phto gear icon ");
		
		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		 photopage.clickonCreatePhotoButton();

		 photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt(1000);

		String nameofphoto = "PER EVENT PRO " + String.valueOf(value);
		
		photopage.createNewSinglePhoto(nameofphoto,"BR");


		extenttest.info("closed the window ");
		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();


		sharepage sharenode = new sharepage();


		sharenode.CreateNewShareNode("print");

		designPage.clickNextButton();
		extenttest.info("click on review next button");
		

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();
		extenttest.info("fill neccessory details for chekout ");


		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");


	

	
	}}
