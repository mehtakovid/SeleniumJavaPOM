package ObjectRepository;

import org.openqa.selenium.By;

public class CreateAccountPageElements {

	
	public By FirstName = By.id("firstname");
	public By LastName = By.id("lastname");
	public By EmailAddress = By.id("email");
	public By password = By.id("password");
	public By ConfirmPassword = By.id("password-confirm");
	public By CreateAccButton = By.xpath("//button[contains(text(),'Create Account')]");
	
}
