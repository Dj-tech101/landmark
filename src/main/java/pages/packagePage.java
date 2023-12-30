package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.controlAction;

public class packagePage  extends controlAction{

	//public WebDriver driver;
	public WebDriverWait wait;

	public packagePage() {
		// TODO Auto-generated constructor stub

		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "btnChangePackage")
	WebElement newPackage;

	public void clickonnewPackageButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(200));

		wait.until(ExpectedConditions.visibilityOf(newPackage)).click();
		;

	}
	
	@FindBy(id = "multiSelect_3")
	WebElement additionalpads;
	
	public void additionalPadselection(int number) {
		
		Select se= new Select(additionalpads);
		
		se.selectByIndex(number);
		
	}
	
	@FindBy(xpath = "(//div[@class='slider round'])[3]")
	WebElement greenScreen;
	
	public void greenScreenselection() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));

		wait.until(ExpectedConditions.visibilityOf(greenScreen)).click();
		;		
	}
	
	@FindBy(xpath = "(//div[@class='slider round'])[4]")
	WebElement whitelable;
	
	
	public void whitebuttonSelection() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));

		wait.until(ExpectedConditions.visibilityOf(whitelable)).click();
		;	
		
	}
	
	@FindBy(id = "btnSelectPackageNext")
	WebElement nextButton;
	public void clickNextButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
		;
		
	}

	@FindBy(xpath = "//button[@id='btnChangePackage']")
	WebElement ChangePackage;
	
	
	public void clickOnPackage() {
		
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		wait.until(ExpectedConditions.visibilityOf(ChangePackage)).click();

	}
	
	
	
}
