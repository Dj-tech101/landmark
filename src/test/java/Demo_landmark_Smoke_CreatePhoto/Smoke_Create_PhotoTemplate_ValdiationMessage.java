package Demo_landmark_Smoke_CreatePhoto;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.TakescreenShotUtils;
import Utility.logger;
import Utility.propertyFile;
import dev.failsafe.internal.util.Assert;
import jdk.internal.org.jline.utils.Log;
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

public class Smoke_Create_PhotoTemplate_ValdiationMessage extends baseclass {

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public Logger log;

	public propertyFile pro;

	//
	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void Validate_Creation_Phototemplate() throws InterruptedException, IOException {

		pro = new propertyFile();
		log = logger.getlogger();

		// Log in with valid credentials
		extenttest.info("Login with valid credentials");
		login = new loginpage();
		login.loginwithCredential(pro.getusername(), pro.getpassword());

		// Navigate to create event page
		creatEvent = new creatEventPage();
		extenttest.info("Click on create new event button");
		creatEvent.clickoncreatEventButton();
		Thread.sleep(2000);

		// Select a package
		packageselect = new packagePage();
		extenttest.info("Click on package");
		packageselect.clickOnPackage();

		// Select package details
		packageDetails = new packageDetails();
		extenttest.info("Select package");
		packageDetails.selectPackage("PER YEAR", "Pro");

		// Fill necessary event details
		eventDetails = new eventDetailsPage();
		Random ran = new Random();
		int number = ran.nextInt(100);
		String name = "PhotoTemplateTest" + String.valueOf(number);
		extenttest.info("Fill necessary data for the event");
		eventDetails.FillNeccessoryDetailsForEvent(name);

		// Navigate to booth design page
		designPage = new boothDesignPage();

		// ************ PHOTO NODE***************

		// Drag and drop photo node
		designPage.dragAndDropphotoNode();

		// Click on photo gear icon
		designPage.clickonPhotoGearIcon();

		// Navigate to create photo page
		PhotoPage photopage = new PhotoPage();
		Thread.sleep(1500);
		extenttest.info("Create a new photo");

		// Create a new photo
		createPhotoPage createPhoto = new createPhotoPage();
		int value = ran.nextInt();
		String nameofphoto = "photonumber" + String.valueOf(value);
		log.info("Select the new photo template options");
		photopage.clickonCreatePhotoButton();
		photopage.clickOnPhotoTemplateButton();
		createPhoto.sendNameTextField(nameofphoto);
//	createPhoto.sendKeysOverlayField();
		createPhoto.clickonSaveButton();

		// Validate that a message is displayed
		String expectedMessage = "Please add placeholders.";
		String actualMessage = createPhoto.getValidationText();
		
		System.out.println("actual message on placeholder is :"+actualMessage);
		
		org.testng.Assert.assertEquals(expectedMessage, actualMessage);

	}
}
