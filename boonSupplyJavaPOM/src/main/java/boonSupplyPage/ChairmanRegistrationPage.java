package boonSupplyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ObjectRepository.ChairmanRegistrationPageElements;

public class ChairmanRegistrationPage extends ChairmanRegistrationPageElements {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public ChairmanRegistrationPage(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	
	public void StandardChairmanRegistration(String firstname, String lastname, String phonenumber, String email, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(firstname);
		driver.findElement(LastName).sendKeys(lastname);
		driver.findElement(PhoneNumber).sendKeys(phonenumber);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(Password_Confirm).sendKeys(password);
		driver.findElement(NextButton).click();
		
		if(driver.findElements(By.xpath("//div[contains(text(),'Email Looks like you already have an')]")).isEmpty()) {
			System.out.println("");
		}else {
			System.out.println("Account Already Exists. Terminate the Program.");
			Assert.fail();
		}
	}
	
	
	public void OnlineChairmanRegistration(String firstname, String lastname, String Email, String Password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(fName)).sendKeys(firstname);
		driver.findElement(lName).sendKeys(lastname);
		driver.findElement(email).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(confirmpassword).sendKeys(Password);
		driver.findElement(ButtonCreateAccount).click();
		
		if(driver.findElements(By.xpath("//div[contains(text(),'Email Looks like you already have an')]")).isEmpty()) {
			System.out.println("");
		}else {
			System.out.println("Account Already Exists. Terminate the Program.");
			System.exit(1);
		}
	}

}
