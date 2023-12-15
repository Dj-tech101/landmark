package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class RegistrationPage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "FirstName")
	WebElement firstName;

	public void sendFirstName(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(name);

	}

	@FindBy(id = "LastName")
	WebElement LastName;

	public void sendLastName(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(LastName)).sendKeys(name);

	}

	@FindBy(id = "Email")
	WebElement Email;

	public void sendEmail(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(name);

	}

	@FindBy(id = "Password")
	WebElement Password;

	public void sendPassword(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(name);

	}

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;

	public void sendConfirmPassword(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(ConfirmPassword)).sendKeys(name);

	}

	@FindBy(id = "create")
	WebElement createButton;

	public void clickoncreateButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

		wait.until(ExpectedConditions.visibilityOf(createButton)).click();

	}

	public String createNewUser() {

		loginpage login = new loginpage(driver);

		login.ClickonSignUpButton();

		RegistrationPage reg = new RegistrationPage(driver);

		reg.sendFirstName("Mahesh");

		reg.sendLastName("Mahesh");

		int ran = new Random().nextInt(100);

		String randomString = "Test" + String.valueOf(ran)+"@user.com";

		reg.sendEmail(randomString);
		String pass = "Mahesh@123";

		reg.sendPassword(pass);
		reg.sendConfirmPassword(pass);

		reg.clickoncreateButton();
		return pass;

	}

}
