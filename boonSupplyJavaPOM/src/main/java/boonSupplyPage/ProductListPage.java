package boonSupplyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.ProductListPageElements;

public class ProductListPage extends ProductListPageElements {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public ProductListPage(WebDriver driver, WebDriverWait wait) {
		ProductListPage.driver=driver;
		ProductListPage.wait=wait;
	}
	
	public void SelectA25$GiftItem(Integer number) {
		System.out.println("Number of items displayed on Page 1 " 
					+wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NumberOfItems)).size());
		Actions action = new Actions(driver);
		System.out.println("Adding the "+number+" item from list");
		action.moveToElement(driver.findElement(By.xpath("//div[@id='ssItems']/article["+number+"]"))).click().build().perform();
		
	}
	
	public void SelectSportsItems(Integer Number) {
		System.out.println("Number of items displayed on Page 1 " 
				+wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NumberOfItems)).size());
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='ssItems']/article["+Number+"]"))).click().build().perform();		
		
	}
	
}
