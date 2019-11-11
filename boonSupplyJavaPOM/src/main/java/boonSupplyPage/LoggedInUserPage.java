package boonSupplyPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.LoggedInUserPageElements;

public class LoggedInUserPage extends LoggedInUserPageElements {

	public static WebDriver driver;
	public static WebDriverWait wait;
	ExtentTest logger;
	
	public LoggedInUserPage(WebDriver driver, WebDriverWait wait,ExtentTest logger) {
		LoggedInUserPage.driver=driver;
		LoggedInUserPage.wait=wait;
		this.logger=logger;
	}
	
	public void existingUserSignIn(String Username, String Password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignInHere)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserEmail)).sendKeys(Username);
		driver.findElement(UserPassword).sendKeys(Password);
		driver.findElement(LoginButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!driver.findElements(ErrorMessage).isEmpty()) {
			Assert.fail("User Does not Exist in the System.");
			logger.log(LogStatus.FAIL, "Existing User Sign in Failed for this Test.");
			
		}else {
			System.out.println("Log in Successful for existing user.");
		}
	}
	
	public void viewAndCloseFundraiser() {
		if(!driver.findElements(fund_alreadyClosed).isEmpty()) {
			logger.log(LogStatus.FAIL, "The fund seems to be already closed.");
			Assert.fail("This fund is already closed.");
		}else {
		wait.until(ExpectedConditions.elementToBeClickable(ViewFundraiser)).click();
		}
		if(driver.findElements(CloseFundraiser).isEmpty()) {
			Assert.fail("The fund is not eligible to be closed. Start date in Future.");
			logger.log(LogStatus.FAIL, "There is no provision to close this fundraiser.");
		}else {
		wait.until(ExpectedConditions.elementToBeClickable(CloseFundraiser)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CloseYourFundraiser2)).click();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(closetext)).isDisplayed(), true);
		}
		
	}
	
	public void CancelMyAccount() {
		
		wait.until(ExpectedConditions.elementToBeClickable(LoginImage)).click();
		//action.moveToElement(driver.findElement(LoginImage)).moveToElement(driver.findElement(YourAccount)).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(CancelYourAccount)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
