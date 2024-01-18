package Com_Landmark_AutoRemovalBackground_Video;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.propertyFile;
import base.controlAction;
import pages.*;

public class Landmark_background_OpenImageForNoneSelection extends baseclass {

	public loginpage login;
	public creatEventPage creatEvent;
	public packagePage packageselect;

	public packageDetails packageDetails;

	public eventDetailsPage eventDetails;

	public boothDesignPage designPage;

	public reviewPage reviewPage;
private VideoPage videopage;

	public propertyFile pro;
    private WebElement element;

    @Test(retryAnalyzer = retryAnalyzerUtil.retryAnalyser.class)
    public void validate_Happypath_Background_IconForNoneSelection() throws InterruptedException, IOException {
        propertyFile pro = new propertyFile();

        extenttest.info("Login with valid credentials");
        login = new loginpage();
        login.loginwithCredential(pro.getusername(), pro.getpassword());

        extenttest.info("Click on create new event button");
        creatEvent = new creatEventPage();
        creatEvent.clickoncreatEventButton();
        Thread.sleep(2000);

        extenttest.info("Click on package");
        packageselect = new packagePage();
        packageselect.clickOnPackage();

        extenttest.info("Select package");
        packageDetails = new packageDetails();
        packageDetails.selectPackage("PER EVENT", "Basic");

        Random ran = new Random();
        String name = "BackGround removal photo" + ran.nextInt(20);
        extenttest.info("Fill necessary data");
        eventDetails = new eventDetailsPage();
        eventDetails.FillNeccessoryDetailsForEvent(name);

        extenttest.info("Design booth with photo node");
        designPage = new boothDesignPage();
        designPage.dragAndDropVideoNode();
        designPage.clickonVideoGearIcon();

        Thread.sleep(1500);
        createVideo("photonumber" + ran.nextInt(12), "M");
    }

    private void createVideo(String nameofphoto, String type) throws InterruptedException, IOException {
        videopage = new VideoPage();
        videopage.clickonCreateVideoButton();

        createVideoPage createVideo = new createVideoPage();
        createVideo.sendVideoname(nameofphoto);
        createVideo.getClickonAAutoRemovalbackButton();

        if (type.contains("GS") || type.contains("greenScreen") || type.equals("BR") || type.contains("Background")) {
            element = createVideo.getopenBackroundSectionElement();
        }

        validateBackgroundUpload();
    }

    private void validateBackgroundUpload() throws InterruptedException, IOException {
        if (element.isEnabled()) {
        	System.out.println("element is displaying");
        	System.out.println(element.getText());
            extenttest.addScreenCaptureFromBase64String(controlAction.takeScreenshot("BACKGROUNDOPENiSDISPLAY"));
            org.testng.Assert.assertTrue(false);
        } else {
        	System.out.println("element is not enable boss");
            org.testng.Assert.assertTrue(true);
        }
    }
}
