package Demo_landmark_SaAdminTestCases;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Demo_landmark_Smoke_CreatePhoto.Smoke_Create_Event_Photo_Test_WithPaylater2;
import Utility.logger;
import Utility.propertyFile;
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

public class VerifySAAdminSimpleDateIntegration extends baseclass {

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
	
	private propertyFile pro;
 	
	
	private MyEventsPage myevents;
	public String EventName;
	
	private Smoke_Create_Event_Photo_Test_WithPaylater2 creator;
	
	
	
	
	
	
	@Test
	public void createBasicEvent() throws InterruptedException, IOException {
	
		 creator= new Smoke_Create_Event_Photo_Test_WithPaylater2();
		
		creator.Validate_Creation_event_with_Gif_with_Paylater();
	          EventName= creator.name;
	           
	  
	}
  // ,
	@Test(dependsOnMethods ={"createBasicEvent"},retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)
	public void SearchUserFunctionTest() throws InterruptedException, IOException {
		
		pro= new propertyFile();
		
		extenttest.info("CLICK ON USER PROFILE BUTTON");
		
		String username=pro.getusername();
		
	      myevents= new  MyEventsPage();
		
		myevents.clickOnUserProfile(username);
		
		extenttest.info("CLICK ON SIGNOUT BUTTON");
		myevents.clcikOnSignOutButton();
		
		
		login = new loginpage();

		
		
		MyEventsPage_SaAdmin myEvent = login.loginwithCredential("sadmin@lapp.com", "ppu12345");
	 
		
        extenttest.info("Search Event ");
		
        Thread.sleep(2000);
		
        myEvent.getSearchFunction(EventName);
        
        myevents.clickOnEditButton();
        
        creator.designPage.clickOnEventDetailsComponent();
        
       System.out.println( creator.eventDetails.getEnddateEvent());
        
//
//		// click on show all button
//		extenttest.info("click on  show all button");
//
//		String before = myEvent.getTotalCountBeforeSwitch();
//
//		// System.out.println("before "+before);
//
//		myEvent.clickOnShowAllSwitch();
//
//		extenttest.info(" count  page event list");
//
//		String after = myEvent.getTotalCountAfterSwitch();
//
//		// System.out.println("after "+after);
//
//		int firstPageCount = myEvent.getCountElmentsPerPage();
//
//		System.out.println("firstPageCount " + firstPageCount);
//
//		String lastPageNumber = null;
//		if (!before.equals(after)) {
//			myEvent.clickOnlastPaginationButton();
//
//			lastPageNumber = myEvent.getTextOfPegiButton();
//
//			controlAction.takeScreenshot("totalCountOfAllEvents");
//
//			Assert.assertTrue(true, "********Test case is failed to get total count*********");
//
//		} else {
//			System.out.println("wait for the switch on");
//		}
	}
}
