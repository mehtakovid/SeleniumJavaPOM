package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.LoginPageElements;

public class LoginPage extends LoginPageElements{

	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		LoginPage.driver=driver;
		LoginPage.wait=wait;
	}
	
	public void EnterCredentials(String UserEmail, String Password) {
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress)).sendKeys(UserEmail);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(SignInButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElements(ErrorOnSignIn).isEmpty()) {
			System.out.println("Login Successful.");
		}else {
			System.out.println("Login Failed");
		}
	}
	
	public void CreateAnAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(CreateAccountLink)).click();
	}
	
	
}
