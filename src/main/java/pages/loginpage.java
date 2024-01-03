package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert.*;

import base.controlAction;

public class loginpage extends controlAction {
	public WebDriverWait wait;

	public loginpage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;

	public void usernamesendkey(String name) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		try {
			wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement usernameInput = wait.until(ExpectedConditions.visibilityOf(email));
			// usernameInput.sendKeys(name);

			waitForElementToBeVisible(email).sendKeys(name);
			
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getLocalizedMessage());
			// Assert.assertTrue(false);
		}

	}

	@FindBy(id = "Password")
	WebElement password;

	public void passwordnamesendkey(String name) {

		waitForElementToBeVisible(password).sendKeys(name);
		;

	}

	@FindBy(xpath = "//input[@value='SIGN IN']")
	WebElement login;

	public MyEventsPage_SaAdmin clickonloginButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(login)).click();

		return new MyEventsPage_SaAdmin();

	}

	public MyEventsPage_SaAdmin loginwithCredential(String user, String pass) {

		usernamesendkey(user);
		passwordnamesendkey(pass);
		MyEventsPage_SaAdmin page=clickonloginButton();
		
		return page;
	}

	@FindBy(xpath = "//a[contains(text(),'SIGN UP')]")
	WebElement signUp;

	public void ClickonSignUpButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(signUp)).click();

	}

	public void loginForNewreg(String pass) {
		passwordnamesendkey(pass);
		clickonloginButton();

	}
}
