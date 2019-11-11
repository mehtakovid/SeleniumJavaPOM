package boonSupplyPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	public void FindFeaturedFundraisers() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeaturedFundRaiser));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(FeaturedFundRaiser)).build().perform();
		List<WebElement> FeaturedFundRaiser = driver.findElements(FeaturedFundRaiser_Description);
		List<String> Funds = new ArrayList<String>();
		for(WebElement ele : FeaturedFundRaiser) {
			Funds.add(ele.getAttribute("data-name"));
		}
		System.out.println("Funds on Featured List: " +Funds);
	
	}
	
	public void GetTrendingItems() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TrendingShoppingItems));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(TrendingShoppingItems)).build().perform();
		List<WebElement> TrendingItems = driver.findElements(TrendingItemName);
		List<String> TrendingName = new ArrayList<String>();
		for(WebElement ele: TrendingItems) {
			TrendingName.add(ele.getText());
		}
		
		System.out.println("Items on Trending List : "+TrendingName);
	}
}
