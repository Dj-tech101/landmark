package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage {
	public WebDriverWait wait;

	public WebDriver driver;

	public loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;

	public void usernamesendkey(String name) {
//		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
//		WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
//		usernameInput.sendKeys(name);

		email.sendKeys(name);
	}

	@FindBy(id = "Password")
	WebElement password;

	public void passwordnamesendkey(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(name);

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
