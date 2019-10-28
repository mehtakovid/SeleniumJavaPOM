package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ObjectRepository.OrganizationSetupPageElements;

public class OrganizationSetupPage extends OrganizationSetupPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public OrganizationSetupPage(WebDriver driver, WebDriverWait wait) {
		OrganizationSetupPage.driver=driver;
		OrganizationSetupPage.wait=wait;
	}
	

	
	public String SearchOrganization(String OrgName, String zipCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrganizationName)).sendKeys(OrgName);
		driver.findElement(OrganizationZipCode).sendKeys(zipCode);
		driver.findElement(SearchOrganization).click();
		if(!driver.findElements(CreateYourOrganization_header).isEmpty()) {
			return "SetupOrganization";
		}else {
			System.out.println("Looks like the Organization is already there.");
			return null;
		}
	}
	
	public void SetupOrganization(String OrgName, String OrgType, String SchoolType, String Adressee, String Address2, 
			String City, String State, String Zip) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Setup_OrganizationName)).sendKeys(OrgName);
		driver.findElement(Setup_OrganizationType).click();
		Select OrgTypeSelect = new Select(driver.findElement(Select_OrganizationType));
		OrgTypeSelect.selectByVisibleText(OrgType);
		
		if(OrgType.contains("sch")) {
			driver.findElement(Setup_SchoolType).click();
			Select SchoolTypeSelect = new Select(driver.findElement(Select_SchoolType));
			SchoolTypeSelect.selectByVisibleText(SchoolType);
			
		}
			driver.findElement(Setup_Address).sendKeys(City);
			driver.findElement(Setup_Addresse).sendKeys(Adressee);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(Setup_Address2)).build().perform();
			driver.findElement(Setup_Address2).click();
			driver.findElement(Setup_Address2).sendKeys(Address2);
			driver.findElement(Setup_City).sendKeys(City);
			driver.findElement(Setup_State).click();
			Select StateSelect = new Select(driver.findElement(Select_State));
			StateSelect.selectByVisibleText(State);
			driver.findElement(Setup_ZipCode).sendKeys(Zip);
			driver.findElement(CreateOrganizationButton).click();
			Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(FundraiserInformationHeader)).isDisplayed(), true);
				
	}
	
}
