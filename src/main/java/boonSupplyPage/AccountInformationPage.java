package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.AccountInformationPageElements;
import junit.framework.Assert;

public class AccountInformationPage extends AccountInformationPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public AccountInformationPage(WebDriver driver, WebDriverWait wait) {
		AccountInformationPage.driver=driver;
		AccountInformationPage.wait=wait;
	}
	
	public void UpdateAccountInformation(String streetName, String cityName, String StateName, String zipCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(StreetName)).clear();
		driver.findElement(StreetName).sendKeys(streetName);
		driver.findElement(City).clear();
		driver.findElement(City).sendKeys(cityName);
		driver.findElement(State).click();
		Select select = new Select(driver.findElement(State));
		select.selectByVisibleText(StateName);
		driver.findElement(ZipCode).clear();
		driver.findElement(ZipCode).sendKeys(zipCode);
		driver.findElement(SavenewInfo).click();
		Assert.assertEquals(true, wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMessage_AccountUpdate)).isDisplayed());
		
	}
	

}
