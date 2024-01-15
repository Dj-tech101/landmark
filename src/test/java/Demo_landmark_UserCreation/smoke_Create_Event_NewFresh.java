package Demo_landmark_UserCreation;

import java.io.IOException;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import pages.CheckoutPage;
import pages.MyEventsPage;
import pages.PhotoPage;
import pages.RegistrationPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class smoke_Create_Event_NewFresh extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public CheckoutPage check;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void TestNewUserCreation() throws InterruptedException, IOException {

		RegistrationPage reg = new RegistrationPage();
		String pass = reg.createNewUser();

		login = new loginpage();

		login.loginForNewreg(pass);

		creatEvent = new creatEventPage();

		creatEvent.clickoncreatEventButton();

		creatEvent.IframeHandle();

		Thread.sleep(3000);

		packageselect = new packagePage();

		// packageselect.clickOnPackage();

		System.out.println("click on new package button");

		// packageselect.clickonnewPackageButton();

		packageDetails = new packageDetails();

		packageDetails.selectPackage("PER MONTH", "Pro");

		System.out.println("fill the neccessory details");

		eventDetails = new eventDetailsPage();
		Random ran = new Random();

		int number = ran.nextInt();
		String name = "CreateNewUserTest" + String.valueOf(number);

		eventDetails.FillNeccessoryDetailsForEvent(name);

		// *****************PhotoNode************

		designPage = new boothDesignPage();

		System.out.println("drag photo to destination");
		designPage.dragAndDropphotoNode();

		System.out.println("click on phto gear icon ");

		designPage.clickonPhotoGearIcon();

		PhotoPage photopage = new PhotoPage();

		Thread.sleep(1500);

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);
		photopage.createNewSinglePhoto(nameofphoto,"BR");

		System.out.println("closed the window ");

		// ****************SHARE NODE*************
		designPage.dragAndDropShare();

		designPage.clickonShareGearIcon();

		System.out.println("lets click on share gear icon");

		sharepage sharenode = new sharepage();
		System.out.println("fll neccessory11 ");

		sharenode.CreateNewShareNode("print");

		System.out.println("fll neccessory 12");
		designPage.clickNextButton();

		reviewPage = new reviewPage();
		System.out.println("fll neccessory 13");

		reviewPage.clickNextButton();
		System.out.println("fll neccessory14");

		check = new CheckoutPage();

		System.out.println("fll neccessory15");

		check.FillNeccessoryCardDetails("New");

		MyEventsPage myEvents = new MyEventsPage();

		String actualName = myEvents.GetEventName();

		Assert.assertEquals(actualName, name);

		System.err.println("Event is created ");

	}
}
