package ObjectRepository;

import org.openqa.selenium.By;

public class ChairmanRegistrationPageElements {
	
	
	//Standard FundRaiser ChairmanDetails
	public By FirstName = By.xpath("//input[@id='user_first_name']");
	public By LastName = By.xpath("//input[@id='user_last_name']");
	public By PhoneNumber = By.xpath("//input[@id='user_phone']");
	public By Email = By.xpath("//input[@id='user_email']");
	public By Password = By.xpath("//input[@id='user_password']");
	public By Password_Confirm = By.xpath("//input[@id='user_password_confirmation']");
	public By NextButton = By.xpath("//input[@value='Next']");
	
	//Online Fundraiser ChairmanDetails
	public By fName = By.xpath("//input[@id='firstname']");
	public By lName = By.xpath("//input[@id='lastname']");
	public By email = By.xpath("//input[@id='email']");
	public By password = By.xpath("//input[@id='password']");
	public By confirmpassword = By.xpath("//input[@id='password-confirm']");
	public By ButtonCreateAccount = By.xpath("//button[contains(text(),'Create Account')]");
	

}
