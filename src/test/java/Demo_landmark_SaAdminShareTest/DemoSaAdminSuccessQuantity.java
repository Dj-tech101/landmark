package Demo_landmark_SaAdminShareTest;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.logger;
import base.controlAction;
import pages.CheckoutPage;
import pages.MyEventsPage;
import pages.MyEventsPage_SaAdmin;
import pages.PhotoPage;
import pages.RegistrationPage;
import pages.SharingEvent;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class DemoSaAdminSuccessQuantity extends baseclass {

	// public Web ;

	private static String eventName = "TESTINGNEWSHAREBYMAHESH";

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public CheckoutPage check;

	private SharingEvent shareEvent;

	public Logger log;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void SharingFunctionTest() throws InterruptedException, IOException {

		log = logger.getlogger();
		login = new loginpage();
		extenttest.info("Login as saadmin user");
		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");

		extenttest.info("Search share event name ");

		myEvent.getSearchFunction(eventName);
		extenttest.info("click on share icon");

		myEvent.getClickShareIcon();

		extenttest.info("validate the functionality ");
		shareEvent = new SharingEvent();

	}

	private void validateSearchFunction(SharingEvent shareEvent) {

		String status = "Suspended";
		shareEvent.searchStatus(status);
	}

	@Test(priority = 1)
	public void validateSearchSuccesStatus() {
		shareEvent = new SharingEvent();
		validateSearchFunction(shareEvent);

		extenttest.info("validate the Suspended message  ");
	}

	public void validateSearchSuccessStatusIfNodata() {
		shareEvent = new SharingEvent();
		validateSearchFunction(shareEvent);
		extenttest.info("validate the Susoended message  ");
	}

	public void validateclearfunction() {
		shareEvent = new SharingEvent();
		validateSearchFunction(shareEvent);
		extenttest.info("validate the Susoended message  ");
	}
}
