package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.HomePageElements;

public class HomePage extends HomePageElements {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		HomePage.driver=driver;
		HomePage.wait=wait;
	}
	
	public void ClickOnFindAFundRaiser() {
		wait.until(ExpectedConditions.elementToBeClickable(fundraise_widget)).click();
		wait.until(ExpectedConditions.elementToBeClickable(findAFundraise)).click();
		
	}
	
	public void GoTo25DollarGiftCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(Shop_Widget)).click();
		wait.until(ExpectedConditions.elementToBeClickable(GiftsUnder25$)).click();
		
	}
	
	public void GoToSportsCollection() {
		wait.until(ExpectedConditions.elementToBeClickable(Shop_Widget)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SportsCollection)).click();
	}
	
	public void ClickOnLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginIcon)).click();
	}
	
	public void GoToAccountDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(LoggedInIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(AccountDetails)).click();
	}
	
	public void StartAFundraiser() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(StartAFundRaiser)).click();
	}
}
