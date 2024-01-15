package Demo_landmark_Sharing_TestCases;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.TakescreenShotUtils;
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

public class Smoke_Create_PerEvent_Basic_EmailShare extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public propertyFile pro;

	@Test(groups = "share", retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void validate_Per_Event_information() throws InterruptedException, IOException {

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
		String name = "TestEmailShare" + String.valueOf(number);

		extenttest.info("fill necccessory data");

		eventDetails.FillNeccessoryDetailsForEvent(name);

		designPage = new boothDesignPage();

		// ************ PHTOT NODE***************88
		designPage.dragAndDropphotoNode();

		extenttest.info("create photo node as single image");

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		photopage.createNewSinglePhoto(nameofphoto,"BR");

		// ************ SHARE NODE***************

		extenttest.info("create Share node ");

		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		sharepage sharenode = new sharepage();

		sharenode.CreateNewShareNode("print");
		sharenode.CreateNewShareNodemore("email", "smugmug");

		extenttest.info("click on next button");

		designPage.clickNextButton();

		reviewPage = new reviewPage();

		reviewPage.clickNextButton();

		CheckoutPage checkoutPage = new CheckoutPage();

		extenttest.info("fill credit details");

	//	TakescreenShotUtils.GetScreenShot(driver, "Creditdetailspage");

		checkoutPage.FillNeccessoryCardDetails("Exist");

		Thread.sleep(4000);

		org.testng.Assert.assertTrue(true);

		System.err.println("Event is created ");

	}
}
