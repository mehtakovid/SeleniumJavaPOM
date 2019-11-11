package ObjectRepository;

import org.openqa.selenium.By;

public class ProductDetailPageElements {

	public By Product_name = By.xpath("//h1[@class='pv-title']");
	public By Product_price = By.xpath("//p[@id='productPrice']");
	public By AddItemtoCart = By.xpath("//button[@id='btnAddToBag']");
	public By ItemAddedInCart = By.xpath("//form[@id='bagForm']/descendant::header[@class='bag-item__header']");
	public By IncreaseQuantity = By.xpath("//div[@class='pv-action pv-qty']//span[3]");
	public By ItemQuantityInCart = By.xpath("//div[@id='bagItems']//input[@name='quantity']");
	public By CheckoutButtonInCart = By.xpath("//a[text()='Check out']");
}
