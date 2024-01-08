package Demo_landmark_SaAdminTestCases;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle.Control;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.logger;
import base.controlAction;
import pages.CheckoutPage;
import pages.ManageUser_SaAdmin;
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

public class DemoSaAdminManageUserSelectUserDetails extends baseclass {

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

	public ManageUser_SaAdmin manageUser;

	@Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)

	public void ManageUserViewUserDetails() throws InterruptedException, IOException {

		log = logger.getlogger();
		login = new loginpage();

		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");
		extenttest.info("click on manage user button");
		myEvent.clickOnManageUserButton();

		String username = "MAHESH100";

		extenttest.info("search username");
		myEvent.searchUserNameManageUser(username);

		extenttest.info("get the information ");

		String actual = getInformationUser(myEvent, username);

		manageUser = new ManageUser_SaAdmin();

		extenttest.info("click on view button");

		manageUser.clickOnViewButton();

		extenttest.info("validateUserName");

		if (actual.contains(manageUser.getIUserEmailText())) {

			Assert.assertTrue(true);
		} else {

			controlAction.takeScreenshot("failManageUserViewUserDetails");
			System.out.println("Test case is failed " + actual + " not equal to " + manageUser.getIUserEmailText());

		}

	}

	private String getInformationUser(MyEventsPage_SaAdmin myEvent, String usernName) throws InterruptedException {

		List<String> information = myEvent.getInformationOfUser();

		// System.out.println("List of the information is : " + information.toString());
		String actual = "";

		for (String info : information) {

			if (info.contains(usernName.toLowerCase())) {
				actual = info;

				System.out.println("The username is : " + actual);
			}
		}
		return actual;
	}
}
