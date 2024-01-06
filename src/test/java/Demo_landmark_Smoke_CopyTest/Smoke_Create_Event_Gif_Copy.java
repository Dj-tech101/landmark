package Demo_landmark_Smoke_CopyTest;
import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import BaseClass.baseclass;
import Utility.logger;
import Utility.propertyFile;
import pages.CheckoutPage;
import pages.GifPage;
import pages.MyEventsPage;
import pages.boothDesignPage;
import pages.creatEventPage;
import pages.createGifPage;
import pages.eventDetailsPage;
import pages.loginpage;
import pages.packagePage;
import pages.sharepage;


public class Smoke_Create_Event_Gif_Copy extends baseclass {

    private loginpage login;
    private creatEventPage creatEvent;
    private packagePage packageselect;
    private pages.packageDetails packageDetails;
    private eventDetailsPage eventDetails;
    private boothDesignPage designPage;
    private pages.reviewPage reviewPage;
    private MyEventsPage myEvents;
    private org.apache.log4j.Logger log;
    private propertyFile property;
    
    public String eventNameUse;

    @Test
    public void verifyCreationOfGif() throws IOException, InterruptedException {
        property = new propertyFile();
        log = logger.getlogger();

        login = new loginpage();
        log.info("Logging in with valid credentials");
        login.loginwithCredential(property.getusername(), property.getpassword());

        creatEvent = new creatEventPage();
        log.info("Clicking on create event button");
        creatEvent.clickoncreatEventButton();
        Thread.sleep(3000);

        packageselect = new packagePage();
        log.info("Selecting the package");
        packageselect.clickOnPackage();

        packageDetails = new pages.packageDetails();
        log.info("Selecting package options");
        packageDetails.selectPackage("PER EVENT", "Pro");

        eventDetails = new eventDetailsPage();
        log.info("Filling event details");
        fillEventDetails(eventDetails);

        designPage = new boothDesignPage();
        log.info("Dragging and dropping Gif node");
        dragAndDropGifNode(designPage);

        designPage.clickonGifGearIcon();
        log.info("Creating new Gif");
        createNewGif(designPage);

        designPage.dragAndDropShare();
        designPage.clickonShareGearIcon();
        log.info("Creating new Share node");
        createNewShareNode(designPage);

        log.info("Reviewing and checking out");
        reviewAndCheckout();
    }

    private void fillEventDetails(eventDetailsPage eventDetails) throws InterruptedException {
        Random ran = new Random();
        int number = ran.nextInt(100);
         eventNameUse = "GifContainEvent" + String.valueOf(number);
        eventDetails.PaylaterFillNeccessoryDetailsForEvent(eventNameUse);
    }


    private void dragAndDropGifNode(boothDesignPage designPage) {
        designPage.dragAndDropGifNode();
    }

    private void createNewGif(boothDesignPage designPage) throws InterruptedException, IOException {
        GifPage gifPage = new GifPage();
        int value = new Random().nextInt();
        String gifName = "gifName" + String.valueOf(value);
        gifPage.clickonCreateGifButton();
        createGifPage createGif = new createGifPage();
        createGif.createGifwithOverlay(gifName);
    }

    private void createNewShareNode(boothDesignPage designPage) throws IOException {
        sharepage shareNode = new sharepage();
        log.info("Selecting the share options");
        shareNode.CreateNewShareNode("print");
    }

    private void reviewAndCheckout() throws InterruptedException {
        designPage.clickNextButton();

        reviewPage = new pages.reviewPage();
        reviewPage.clickNextButton();

        CheckoutPage checkoutPage = new CheckoutPage();
        log.info("Filling necessary checkout data");
        checkoutPage.clickOnPayLaterButton();

        Thread.sleep(4000);

        myEvents = new MyEventsPage();
        log.info("Searching for the event");
        myEvents.serachEventsAction(eventNameUse);
    }

    private void reviewAndCheckoutAfterEdit() throws InterruptedException {
        designPage.clickNextButton();

        reviewPage = new pages.reviewPage();
        reviewPage.clickNextButton();

//        CheckoutPage checkoutPage = new CheckoutPage();
//        log.info("Filling necessary checkout data");
//        checkoutPage.clickOnPayLaterButton();

        Thread.sleep(4000);

        myEvents = new MyEventsPage();
        log.info("Searching for the event");
        myEvents.serachEventsAction(eventNameUse);
    }
    @Test(dependsOnMethods = "verifyCreationOfGif")
    public void validateCopyFunction() throws InterruptedException {
        log.info("Copy button click");

        Random ran = new Random();
        String newEventName = "copyEvent" + eventNameUse + String.valueOf(ran.nextInt(120));
        myEvents.copyExistEvent(newEventName);

        packageselect.clickNextButton();
        eventDetails.copyEventFillNeccessoryDetailsForEvent();

        designPage = new boothDesignPage();
        designPage.clickNextButton();

        reviewAndCheckoutAfterEdit();
    }
}
