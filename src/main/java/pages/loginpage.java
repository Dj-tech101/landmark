package pages;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert .*;

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

		try {
			wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement usernameInput = wait.until(ExpectedConditions.visibilityOf(email));
			// usernameInput.sendKeys(name);

			usernameInput.sendKeys(name);
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

	public void clickonloginButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(login)).click();

	}

	public void loginwithCredential(String user, String pass) {

		usernamesendkey(user);
		passwordnamesendkey(pass);
		clickonloginButton();
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
