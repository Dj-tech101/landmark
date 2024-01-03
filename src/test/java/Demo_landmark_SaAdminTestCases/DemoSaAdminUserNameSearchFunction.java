package Demo_landmark_SaAdminTestCases;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.logger;
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

public class DemoSaAdminUserNameSearchFunction extends baseclass {

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
		 
           log=logger.getlogger();

	        MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");

	        log.info("search userName ");
	        
	        String userName = "MAHESH100";

	        myEvent.searchUserName(userName);

	        String names = myEvent.getNameOfUserNames();

	        log.info("Actual name of user is : "+names);

	        if (names.contains(userName)) {
	           log.info("Test Passed! User with name {0} found.");
	            Assert.assertTrue(true);
	        } else {
	            Assert.assertTrue(false);
	        }
	    }
}
