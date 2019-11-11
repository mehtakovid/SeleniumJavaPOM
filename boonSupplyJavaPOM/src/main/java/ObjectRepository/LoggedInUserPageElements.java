package ObjectRepository;

import org.openqa.selenium.By;

public class LoggedInUserPageElements {

	
	//existing User Sign in
		public By SignInHere = By.xpath("//a[text()='Sign in here']");
		public By UserEmail = By.xpath("//input[@name='user[email]']");
		public By UserPassword = By.xpath("//input[@name='user[password]']");
		public By LoginButton = By.xpath("//input[@value='Log in']");
		public By ErrorMessage = By.xpath("//div[@class='alert alert-danger']");
		
		public By fund_alreadyClosed = By.xpath("//span[text()='Closed']");
		public By ViewFundraiser = By.xpath("//span[text()='VIEW FUNDRAISER']");
		public By CloseFundraiser = By.xpath("//a[text()='CLOSE FUNDRAISER']");
		public By CloseYourFundraiser2 = By.xpath("//input[@id='close-process-submit']");
		public By closetext = By.xpath("//span[text()='closed']");
		
		public By LoginImage = By.xpath("//img[@id='loginImg']");
		public By YourAccount = By.xpath("//a[text()='Your Account']");
		
		public By CancelYourAccount = By.xpath("//input[@value='Cancel my account']");
		public By FlashNotice = By.xpath("//div[@id='flash_notice']");
		
}
