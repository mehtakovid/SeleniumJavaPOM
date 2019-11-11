package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ObjectRepository.CheckOutPageElements;

public class CheckOutPage extends CheckOutPageElements {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public CheckOutPage(WebDriver driver,WebDriverWait wait) {
		CheckOutPage.driver=driver;
		CheckOutPage.wait=wait;
	}
	
	public void ValidatePricingOnCheckoutPage() {
		String TotalItems = wait.until(ExpectedConditions.visibilityOfElementLocated(NumberOfItemInCart)).getAttribute("value");
		String PriceOfOneItem = driver.findElement(PerItemPrice).getText().substring(1,3);
		System.out.println("Total Items and Price of One Item in String : "+TotalItems +" And "+PriceOfOneItem);
		Integer ExpectedPrice = Integer.parseInt(TotalItems)*Integer.parseInt(PriceOfOneItem);
		Integer ActualPrice = Integer.parseInt(driver.findElement(TotalPrice).getText().substring(1, 4));
		Assert.assertEquals(ActualPrice, ExpectedPrice);
		
	}
	
}
