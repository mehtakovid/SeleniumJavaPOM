package ObjectRepository;

import org.openqa.selenium.By;

public class AccountInformationPageElements {

	
	public By StreetName = By.xpath("//input[@name='street']");
	public By City = By.xpath("//input[@name='city']");
	public By State = By.xpath("//select[@name='state']");
	public By ZipCode = By.xpath("//input[@name='zip']");
	public By SavenewInfo = By.xpath("//span[text()='Save New Info']");
	public By SuccessMessage_AccountUpdate = By.xpath("//div[text()='Account Information updated.']");
}
