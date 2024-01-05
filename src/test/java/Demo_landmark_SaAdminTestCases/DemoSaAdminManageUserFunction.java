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

public class DemoSaAdminManageUserFunction extends baseclass {

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

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void ManageUserSearchFunction() throws InterruptedException, IOException {

		log = logger.getlogger();
		login = new loginpage();

		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");
		log.info("click on manage user button");
		myEvent.clickOnManageUserButton();

		String username = "MAHESH100";

		log.info("search username");
		myEvent.searchUserNameManageUser(username);

		log.info("get the information and validate ");

		List<String> information = myEvent.getInformationOfUser();

		// System.out.println("List of the information is : " + information.toString());

		for (String info : information) {
		
			

			if (info.contains(username.toLowerCase())) {

				System.out.println("The username is : " + info);

				controlAction.takeScreenshot("ManageUserSearchFunction");
				Assert.assertTrue(true, "Username is not match for ManageUserSearchFunction");

			}
		}
	}
}
