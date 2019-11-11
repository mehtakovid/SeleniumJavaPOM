package ObjectRepository;

import org.openqa.selenium.By;

public class LoginPageElements {

	public By emailAddress = By.xpath("//input[@id='email']");
	public By password = By.xpath("//input[@id='password']");
	public By SignInButton = By.xpath("//button[text()='Sign In']");
	public By ErrorOnSignIn = By.xpath("//*[@id='formMessages']/div");
	public By CreateAccountLink = By.xpath("//a[text()='create an account here']");




}
