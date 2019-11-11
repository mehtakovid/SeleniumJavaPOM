package ObjectRepository;

import org.openqa.selenium.By;

public class CheckOutPageElements {

	public By NumberOfItemInCart = By.cssSelector("input[name='quantity']");
	public By PerItemPrice = By.cssSelector("p[class='bag-item__price']>span");
	public By TotalPrice = By.cssSelector("span[id='bagSubtotal']");
	public By CheckoutButton = By.xpath("//button[contains(text(),'Check out')]");
	
	
}
