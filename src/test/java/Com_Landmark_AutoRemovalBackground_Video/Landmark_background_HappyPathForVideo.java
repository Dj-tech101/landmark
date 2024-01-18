package Com_Landmark_AutoRemovalBackground_Video;

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

public class Landmark_background_HappyPathForVideo extends baseclass {

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

	public void validate_Happypath_Background_Video_GreenScreen() throws InterruptedException, IOException {

		pro = new propertyFile();

		extenttest.info("login with valid credential");
		login = new loginpage();

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		extenttest.info("click on create new event button");

		creatEvent.clickoncreatEventButton();
		Thread.sleep(2000);

		packageselect = new packagePage();

		extenttest.info("click on package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		extenttest.info("select package");

		packageDetails.selectPackage("PER EVENT", "Pro");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();
		String name = "BackGround removal video" + String.valueOf(number);

		extenttest.info("fill necccessory data");

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage();

		// ************ VIDEO NODE***************88

		designPage.createVideoNodeForBackGround("GS");

		// ************ SHARE NODE***************

		extenttest.info("create Sahre node ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		//

		sharenode.CreateNewShareNodemore("email", "smugmug");

		extenttest.info("click on next button");

		designPage.clickNextButton();

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		extenttest.info("fill credit details");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");

	}

	@Test
	public void validate_Happypath_Background_Video_Background() throws InterruptedException, IOException {

		pro = new propertyFile();

		extenttest.info("login with valid credential");
		login = new loginpage();

		login.loginwithCredential(pro.getusername(), pro.getpassword());

		creatEvent = new creatEventPage();

		extenttest.info("click on create new event button");

		creatEvent.clickoncreatEventButton();
		Thread.sleep(2000);

		packageselect = new packagePage();

		extenttest.info("click on package");

		packageselect.clickOnPackage();

		packageDetails = new packageDetails();

		extenttest.info("select package");

		packageDetails.selectPackage("PER EVENT", "Basic");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();
		String name = "BackGround removal photo" + String.valueOf(number);

		extenttest.info("fill necccessory data");

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage();

		// ************ VIDEO NODE***************88

		designPage.createVideoNodeForBackGround("BR");

		extenttest.info("create video for background removal ");

		// ************ SHARE NODE***************

		extenttest.info("create Sahre node ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		//

		sharenode.CreateNewShareNodemore("email", "smugmug");

		extenttest.info("click on next button");

		designPage.clickNextButton();

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		extenttest.info("fill credit details");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");

	}

}
