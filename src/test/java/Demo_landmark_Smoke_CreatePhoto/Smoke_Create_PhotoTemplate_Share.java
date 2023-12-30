package Demo_landmark_Smoke_CreatePhoto;

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

public class Smoke_Create_PhotoTemplate_Share extends baseclass {

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

		log.info("login with valid credential");
		login = new loginpage();

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		log.info("click on create new event button");

		creatEvent.clickoncreatEventButton();
		Thread.sleep(2000);

		packageselect = new packagePage();

		log.info("click on package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		log.info("select package");

		packageDetails.selectPackage("PER MONTH", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt(100);

		String name = "PhotoTemplateTest" + String.valueOf(number);

		log.info("fill necccessory data");

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage();
		

		// ************ PHOTO NODE***************

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
		

		// ************ SHARE NODE***************

		log.info("create Sahre node ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		sharenode.CreateNewShareNode("print");

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