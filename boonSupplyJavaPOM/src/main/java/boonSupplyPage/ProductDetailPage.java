package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ObjectRepository.ProductDetailPageElements;

public class ProductDetailPage extends ProductDetailPageElements {

	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
		ProductDetailPage.driver=driver;
		ProductDetailPage.wait=wait;
	}
	
	public boolean AddTheSelectedProductToCart() {
		String productName = wait.until(ExpectedConditions.visibilityOfElementLocated(Product_name)).getText();
		System.out.println("Name of the Selected Product : " +productName);
		System.out.println("Price of the Selected Product : " +wait.until(ExpectedConditions.visibilityOfElementLocated(Product_price)).getText());
		driver.findElement(AddItemtoCart).click();
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(ItemAddedInCart)).getText().contains(productName)) {
			System.out.println("Item Successfully Added in Cart");
			return true;
		}else {
			System.out.println("Failed to Add product in Cart.");
			return false;
		}
	}
	
	public boolean AddMultipleItemInCart(Integer Quantity) {
		String productName = wait.until(ExpectedConditions.visibilityOfElementLocated(Product_name)).getText();
		for(int i=0; i<Quantity; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(IncreaseQuantity)).click();
		}
		
		driver.findElement(AddItemtoCart).click();
		Integer cartQuantity = Quantity+1;
		
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(ItemAddedInCart)).getText().contains(productName) && 
				wait.until(ExpectedConditions.visibilityOfElementLocated(ItemQuantityInCart)).getAttribute("value").contains(cartQuantity.toString())) {
			System.out.println("Item Successfully Added in Cart with correct quantity.");
			return true;
		}else {
			Assert.fail("Failed to Add product in Cart with correct quanitity.");
			return false;
		}
		
		
	}
	
	public void ClickOnCheckoutButtonInCart() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutButtonInCart)).click();
	}
}
