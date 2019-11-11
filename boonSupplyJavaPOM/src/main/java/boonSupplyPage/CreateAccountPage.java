package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.CreateAccountPageElements;

public class CreateAccountPage extends CreateAccountPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public CreateAccountPage(WebDriver driver, WebDriverWait wait) {
		CreateAccountPage.driver=driver;
		CreateAccountPage.wait=wait;
	}
	
	public void CreateNewAccount(String firstName, String lastname, String emailaddress, String Password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(firstName);
		driver.findElement(LastName).sendKeys(lastname);
		driver.findElement(EmailAddress).sendKeys(emailaddress);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(ConfirmPassword).sendKeys(Password);
//		driver.findElement(CreateAccButton).click();
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
