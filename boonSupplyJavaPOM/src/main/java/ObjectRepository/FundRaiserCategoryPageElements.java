package ObjectRepository;

import org.openqa.selenium.By;

public class FundRaiserCategoryPageElements {

	public By Search_FundRaiser = By.xpath("//button[contains(text(),'Search')]/preceding-sibling::div/input[@id='fundCatInput']");
	public By SearchButton = By.xpath("//button[contains(text(),'Search')]");
	public By Search_Header = By.xpath("//header[@class='search-cat__header']");
	public By SearchResults_Number = By.xpath("//header[@class='search-cat__header']//p[1]");
	
	
}
