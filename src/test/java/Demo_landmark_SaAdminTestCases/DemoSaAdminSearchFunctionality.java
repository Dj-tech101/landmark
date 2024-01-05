package Demo_landmark_SaAdminTestCases;

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
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createPhotoPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packageDetails;
import pages.packagePage;
import pages.reviewPage;
import pages.sharepage;

public class DemoSaAdminSearchFunctionality extends baseclass {

	// public Web ;

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;

	public CheckoutPage check;

	public Logger log;
//retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class
	@Test()

	public void SearchEventNameFunction() throws InterruptedException, IOException {

		log = logger.getlogger();
		login = new loginpage();

		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");
		String testName = "PAYLATER";
		log.info("search event name start with :" + testName);

		myEvent.getSearchFunction(testName);

		List<String> EventNameCollections = myEvent.getlistofEventsOnPage();

		for (String eventname : EventNameCollections) {


			if (eventname.contains(testName)) {

				log.log(Level.INFO, "Test Passed! User");
				Assert.assertTrue(false);
			} else {
				controlAction.takeScreenshot("fail_SearchEventNameFunction");
				Assert.assertTrue(false);
				
			}
		}

	}
}
