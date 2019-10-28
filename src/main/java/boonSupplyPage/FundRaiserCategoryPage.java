package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.FundRaiserCategoryPageElements;

public class FundRaiserCategoryPage extends FundRaiserCategoryPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public FundRaiserCategoryPage(WebDriver driver, WebDriverWait wait) {
		FundRaiserCategoryPage.driver=driver;
		FundRaiserCategoryPage.wait=wait;
	}
	
	public boolean SearchTheFundRaiser(String SearchInput) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Search_FundRaiser)).sendKeys(SearchInput);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(SearchButton).click();
		String SearchResultText = wait.until(ExpectedConditions.visibilityOfElementLocated(Search_Header)).getText();
		
		if(SearchResultText.contains("SEARCH RESULTS FOR")) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
