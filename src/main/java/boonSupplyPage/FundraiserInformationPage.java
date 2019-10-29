package boonSupplyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ObjectRepository.FundraiserInformationPageElements;

public class FundraiserInformationPage extends FundraiserInformationPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public FundraiserInformationPage(WebDriver driver, WebDriverWait wait) {
		FundraiserInformationPage.driver=driver;
		FundraiserInformationPage.wait=wait;
	}
	
	
	public void FundRaiserInformation(String fundraiserSize, String catalogNumber, String StartMonth, String StartDate, String EndMonth, String EndDate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FundraiserSize)).sendKeys(fundraiserSize);
		driver.findElement(NumberOfCatalogsNeeded).sendKeys(catalogNumber);
		driver.findElement(FundraiserStartDate).click();

		if(driver.findElement(MonthandYear).getText().contains(StartMonth)) {
			System.out.println("this is the current month");
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::tr//td//a[text()='"+StartDate+"']")).click();
		}else {
			while(!driver.findElement(MonthandYear).getText().contains(StartMonth)){
				System.out.println("In While loop Start Date");
				driver.findElement(NextMonth).click();
			}
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::tr//td//a[text()='"+StartDate+"']")).click();	
			
		}
		
		System.out.println("Start Date Selected");
		driver.findElement(FundraiserEndDate).click();
		
		if(driver.findElement(MonthandYear).getText().contains(EndMonth)) {
			System.out.println("this is the current month");
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::tr//td//a[text()='"+EndDate+"']")).click();
		}else {
			while(!driver.findElement(MonthandYear).getText().contains(EndMonth)){
				System.out.println("In While loop End Date");
				driver.findElement(NextMonth).click();
			}
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::tr//td//a[text()='"+EndDate+"']")).click();	
			
		}
		
		driver.findElement(nextButton_fundraiserInformation).click();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(FundraiserProgramHeader)).isDisplayed(), true);
			
	}
	
	public void FundraiserPrograms(String FundRaiserType) {
		if(FundRaiserType.equalsIgnoreCase("OnlineOnly")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(OnlineOnly_RadioButton)).click();
		}else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogFundraiser_RadioButton)).click();
		}
		
		driver.findElement(NextButton_FundraiserProgram).click();
		
	}
	
	public void acceptTOSToConfirmFundraiserCreation() {
		wait.until(ExpectedConditions.elementToBeClickable(TOSAgreeButton)).click();
		System.out.println("Below are the new fundraiser details : " +driver.findElement(FundRaiserName).getText() +driver.findElement(FundraiserDate).getText());
	}
	
	public void SetupOnlineFundRaiserPageOne(String FundraiserName, String WhoIsItFor) {
		wait.until(ExpectedConditions.elementToBeClickable(Online_FundRaiserName)).click();
		driver.findElement(Online_FundRaiserName).sendKeys(FundraiserName);
		driver.findElement(Who_is_it_For).click();
		driver.findElement(By.xpath("//ul[@id='ssDropdown']/li[contains(text(),'"+WhoIsItFor+"')]")).click();
		driver.findElement(NextButton).click();
	}
	
	public void EnterFundRaiserInfo(String firstname, String lastName, String email, String Phone) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fundContactName)).click();
		driver.findElement(fundContactName).sendKeys(firstname);
		driver.findElement(fundContactLastName).sendKeys(lastName);
		driver.findElement(fundAddress).sendKeys("2");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		driver.findElement(fundAddress).click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(fundEmail).click();
		driver.findElement(fundEmail).sendKeys(email);
		driver.findElement(fundPhone).sendKeys(Phone);
		driver.findElement(NotWorkingwithAnyConsultants).click();
		driver.findElement(NextButton).click();
		
		
	}
	
	//needs to be updated to take user input
	public void EnterFundraiserGoals() {
		wait.until(ExpectedConditions.elementToBeClickable(No_goalAtThisTime)).click();
		driver.findElement(No_earningsVisible).click();
		driver.findElement(StartDate).click();
		driver.findElement(StartDateOption_StartNow).click();
		driver.findElement(EndDate).click();
		driver.findElement(EndDateOption_EndIn1week).click();
		driver.findElement(NextButton).click();
	}
	
	//needs to be updated to take user input
	public void FundraiserStyle(String GrpOrInd, String Catalog) {
		if(GrpOrInd.equalsIgnoreCase("Group") && Catalog.equalsIgnoreCase("No")) {
			wait.until(ExpectedConditions.elementToBeClickable(fundraiserStyle_Group)).click();
			wait.until(ExpectedConditions.elementToBeClickable(No_CatalogeRequired)).click();
		}
		else if(GrpOrInd.equalsIgnoreCase("Individual") && Catalog.equalsIgnoreCase("No")) {
			wait.until(ExpectedConditions.elementToBeClickable(fundraiserStyle_individual)).click();
			wait.until(ExpectedConditions.elementToBeClickable(No_CatalogeRequired)).click();
		}
		else if(GrpOrInd.equalsIgnoreCase("Individual") && Catalog.equalsIgnoreCase("Yes")) {
			wait.until(ExpectedConditions.elementToBeClickable(fundraiserStyle_individual)).click();
			wait.until(ExpectedConditions.elementToBeClickable(Yes_CatalogeRequired)).click();
		}
		else if(GrpOrInd.equalsIgnoreCase("Group") && Catalog.equalsIgnoreCase("Yes")) {
			wait.until(ExpectedConditions.elementToBeClickable(fundraiserStyle_Group)).click();
			wait.until(ExpectedConditions.elementToBeClickable(Yes_CatalogeRequired)).click();
		}
		
		driver.findElement(NextButton).click();
	}
	
	public boolean fundraisingFocus(String focustopic ) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FundrasingFocusHeader));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='form-list category-list']/li/descendant::span[contains(text(),'"+focustopic+"')]"))).click();
		driver.findElement(CustomizeMyFundraiser).click();
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(ReadyToLaunchText)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}

}
