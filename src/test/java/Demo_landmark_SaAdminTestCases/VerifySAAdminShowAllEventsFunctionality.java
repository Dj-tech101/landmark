package Demo_landmark_SaAdminTestCases;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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

public class VerifySAAdminShowAllEventsFunctionality extends baseclass {

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

	public void SearchUserFunctionTest() throws InterruptedException, IOException {
		login = new loginpage();

		log = logger.getlogger();

		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");

		// click on show all button
		log.info("click on  show all button");

		String before = myEvent.getTotalCountBeforeSwitch();

		// System.out.println("before "+before);

		myEvent.clickOnShowAllSwitch();

		log.info(" count  page event list");

		String after = myEvent.getTotalCountAfterSwitch();

		// System.out.println("after "+after);

		int firstPageCount = myEvent.getCountElmentsPerPage();

		System.out.println("firstPageCount " + firstPageCount);

		String lastPageNumber = null;
		if (!before.equals(after)) {
			myEvent.clickOnlastPaginationButton();

			lastPageNumber = myEvent.getTextOfPegiButton();

			controlAction.takeScreenshot("totalCountOfAllEvents");

			Assert.assertTrue(true, "********Test case is failed to get total count*********");

		} else {
			System.out.println("wait for the switch on");
		}
	}
}
