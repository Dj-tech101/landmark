package Com_Landmark_AutoRemovalBackground;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.baseclass;
import Utility.logger;
import Utility.propertyFile;
import base.controlAction;
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

public class Landmark_background_Negative extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public propertyFile pro;

	private static PhotoPage photopage;
	
	private WebElement element;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void validate_Happypath_Background_photoWithoutBackground() throws InterruptedException, IOException {

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

		// ************ PHTOT NODE***************88
		designPage.dragAndDropphotoNode();

		extenttest.info("create photo node as single image");

		designPage.clickonPhotoGearIcon();

		photopage = new PhotoPage();

		Thread.sleep(1500);

		createPhotoPage createPhoto = new createPhotoPage();

		int value = ran.nextInt();

		String nameofphoto = "photonumber" + String.valueOf(value);

		createNewSinglePhotoWithoutBackground(nameofphoto, "BR");

		// ************ SHARE NODE***************

//			extenttest.info("create Sahre node ");
//
//			designPage.dragAndDropShare();
//
//			designPage.clickonShareGearIcon();
//
//			sharepage sharenode = new sharepage();
//
//			//
//
//			sharenode.CreateNewShareNodemore("email", "smugmug");
//
//			extenttest.info("click on next button");
//
//			designPage.clickNextButton();
//
//			reviewPage = new reviewPage();
//
//			reviewPage.clickNextButton();
//
//			CheckoutPage checkoutPage = new CheckoutPage();
//
//			extenttest.info("fill credit details");
//
//			checkoutPage.FillNeccessoryCardDetails("Exist");
//
//			Thread.sleep(4000);
//
//			org.testng.Assert.assertTrue(true);
//
//			System.err.println("Event is created ");

	}

	
	// @Test(priority = 1)
	public void validateGreenScreenElementForGreenScreenSelection() {

		try {

			if (photopage.getGreenScreenElement().isDisplayed()) {

				extenttest.addScreenCaptureFromBase64String(controlAction.takeScreenshot("greenScreenElement"));

			} else {
				org.testng.Assert.assertTrue(true, "Green screen is not display");

			}

		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception n) {
			System.out.println(n.getMessage());

		}
	}

	@Test(priority = 1)
	public void validateGreenScreenElementForAutoBackgroundSelection() {

		try {

			if (photopage.getGreenScreenElement().isDisplayed()) {

				extenttest.addScreenCaptureFromBase64String(controlAction.takeScreenshot("greenScreenElement"));
				org.testng.Assert.assertTrue(false, "Green screen is display");

			} else {

				org.testng.Assert.assertTrue(true, "Green screen is not display");

			}

		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception n) {
			System.out.println(n.getMessage());

		}
	}

	private void createNewSinglePhotoWithoutBackground(String nameofphoto, String Type)
			throws InterruptedException, IOException {

		photopage = new PhotoPage();

		photopage.clickonCreatePhotoButton();

		photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage();

		createPhoto.sendNameTextField(nameofphoto);

		createPhoto.getClickonAAutoRemovalbackButton();

		if (Type.contains("GS") || Type.contains("greenScreen")) {

			createPhoto.clickOnGreenScreenToggle();

			createPhoto.sendKeysOverlayField();

			// createPhoto.clickonSaveButton();

			// photopage.clickOnClosedPhotoWindow(nameofphoto);

		} else if (Type.equals("BR") || Type.contains("Background")) {

			createPhoto.clickOnAutoBackgroundRemovalToggle();

			// createPhoto.sendKeysBackgroundImage();

			createPhoto.sendKeysOverlayField();

//			createPhoto.clickonSaveButton();
//
//			photopage.clickOnClosedPhotoWindow(nameofphoto);
		}
	}

	private WebElement getBackggroundUploadingForNoneSelection(String nameofphoto, String Type)
			throws InterruptedException, IOException {

		

		photopage = new PhotoPage();

		photopage.clickonCreatePhotoButton();

		photopage.clickOnSingleImageButton();

		createPhotoPage createPhoto = new createPhotoPage();

		createPhoto.sendNameTextField(nameofphoto);

		createPhoto.getClickonAAutoRemovalbackButton();

		if (Type.contains("GS") || Type.contains("greenScreen")) {

			// createPhoto.clickOnGreenScreenToggle();

			element = createPhoto.getopenBackroundSectionElement();

			// createPhoto.sendKeysOverlayField();

			// createPhoto.clickonSaveButton();

			// photopage.clickOnClosedPhotoWindow(nameofphoto);

		} else if (Type.equals("BR") || Type.contains("Background")) {

			// createPhoto.clickOnAutoBackgroundRemovalToggle();

			// createPhoto.sendKeysBackgroundImage();
			element = createPhoto.getopenBackroundSectionElement();

			// createPhoto.sendKeysOverlayField();

//				createPhoto.clickonSaveButton();
			//
//				photopage.clickOnClosedPhotoWindow(nameofphoto);
		}
		return element;
	}

}
