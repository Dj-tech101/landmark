package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.controlAction;

public class packageDetails extends controlAction {
	//public WebDriver driver;
	public WebDriverWait wait;

	public JavascriptExecutor js;

	public packageDetails() {
		// TODO Auto-generated constructor stub

		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[contains(text(),'PER EVENT')]")
	WebElement perEvent;

	@FindBy(xpath = "//button[contains(text(),'PER MONTH')]")
	WebElement permonth;

	@FindBy(xpath = "//button[contains(text(),'PER EVENT')]")
	WebElement perYear;

	public void clickOnPerEvent() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(perEvent)).click();
		;

	}

	public void clickOnPerMonth() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(permonth));
		;
		try {
			js.executeScript("arguments[0].click();", element);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void clickOnPerYear() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(perYear)).click();
		;
	}

	@FindBy(id = "btnSelectPackageNext")
	WebElement nextButton;

	public void clickNextButton() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(nextButton));
		;
		js = (JavascriptExecutor) driver;

		try {
			js.executeScript("arguments[0].click();", e1);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
	}

	@FindBy(xpath = "//button[ @data-packageid='1']")
	List<WebElement> selectButtonPerEventList;;

	@FindBy(xpath = "//div[@id='package_2']/div[2]/div/div/ul/li[20]/button")
	List<WebElement> selectButtonPerMonthList;;

	@FindBy(xpath = "//div[@id='package_3']/div[2]/div/div/ul/li[20]/button")
	List<WebElement> selectButtonPerYearList;;

	public void clickSelectButton(String packageName, String Type) {
		js = (JavascriptExecutor) driver;

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		int Packages = 3;

		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		System.out.println("ready to select ");

		if (packageName.equals("PER EVENT")) {
			for (int j = 0; j < selectButtonPerEventList.size(); j++) {
				if (Type.contains("Basic")) {
					if (j == 0) {
						WebElement e1 = selectButtonPerEventList.get(j);
						try {
							js.executeScript("arguments[0].click();", e1);
							break;
						} catch (NoSuchElementException e) {
							// TODO: handle exception
							System.out.println(e.getMessage());

						}
					}
				} else {
					j++;

					WebElement e1 = selectButtonPerEventList.get(j);
					try {
						js.executeScript("arguments[0].click();", e1);
						break;
					} catch (NoSuchElementException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());

					}
				}
			}
		}

		else if (packageName.contains("PER MONTH")) {

			for (int j = 0; j < selectButtonPerMonthList.size(); j++) {

				if (Type.contains("Basic")) {
					if (j == 0) {
						WebElement e1 = selectButtonPerMonthList.get(j);
						try {

							js.executeScript("arguments[0].click();", e1);
							break;

						} catch (NoSuchElementException e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
					}
				} else if (Type.contains("Pro")) {

					j++;

					System.out.println("click on per month pro ");
					WebElement e1 = selectButtonPerMonthList.get(j);
					try {
						js.executeScript("arguments[0].click();", e1);
//						Actions act1 = new Actions(driver);
//
//						act1.click(e1).perform();
						break;
					} catch (NoSuchElementException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());

					}
				}
			}

		} else if (packageName.contains("PER YEAR")) {
			

			for (int j = 0; j < selectButtonPerYearList.size(); j++) {

				if (Type.contains("Basic")) {
					if (j == 0) {
						WebElement e1 = selectButtonPerMonthList.get(j);
						try {
							js.executeScript("arguments[0].click();", e1);
							break;

						} catch (NoSuchElementException e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
					}
				} else if (Type.contains("Pro")) {

					j++;

					WebElement e1 = selectButtonPerMonthList.get(j);
					try {
						js.executeScript("arguments[0].click();", e1);
						break;
					} catch (NoSuchElementException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());

					}
				}
			}
		}

	}

	@FindBy(xpath = "//button[starts-with(text(), 'PER')]")
	List<WebElement> PackageList;

	@FindBy(xpath = "(//div[@class='slider round'])[1]")
	WebElement GreenScreenToggle;

	public void switchGreenScreenToggle() {
		wait = new WebDriverWait(driver, Duration.ofMinutes(5));

		wait.until(ExpectedConditions.visibilityOf(GreenScreenToggle)).click();
	}

	public void selectPackage(String Package, String Type) throws InterruptedException {

		packageDetails details = new packageDetails();

		for (WebElement packages : PackageList) {

			String nameofPck = packages.getText();

			if (nameofPck.contains(Package)) {

				wait = new WebDriverWait(driver, Duration.ofSeconds(15));

				wait.until(ExpectedConditions.visibilityOf(packages)).click();

				Thread.sleep(1500);

				details.clickSelectButton(nameofPck, Type);

				Thread.sleep(1500);

				if (Type.contains("Basic")) {

					details.switchGreenScreenToggle();

				}

				details.clickNextButton();

				break;

			}
		}

	}

}
