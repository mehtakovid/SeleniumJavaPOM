package boonSupplyTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DataReader;
import Utilities.TakeAScreenshot;
import boonSupplyPage.HomePage;
import boonSupplyPage.LoggedInUserPage;
import boonSupplyPage.LoginPage;
import boonSupplyPage.OrganizationSetupPage;
import boonSupplyPage.ProductDetailPage;
import boonSupplyPage.ProductListPage;
import boonSupplyPage.AccountInformationPage;
import boonSupplyPage.ChairmanRegistrationPage;
import boonSupplyPage.CreateAccountPage;
import boonSupplyPage.CreateFundraiserPage;
import boonSupplyPage.FundRaiserCategoryPage;
import boonSupplyPage.FundraiserInformationPage;

public class BoonSupplyTests {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeMethod
	public void DriverInitialization() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,60);
		driver.get("https://www.boonsupply.com/");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	
	
	/****
	 * Validate Customer can Search for a Fund-raiser
	 * @throws Exception 
	 */
	
	@Test(priority=1,enabled=true)
	public void SearchAFundraiser() throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnFindAFundRaiser();
		FundRaiserCategoryPage TS2 = new FundRaiserCategoryPage(driver, wait);
		TS2.SearchTheFundRaiser("California");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality Manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-1");
		}
		
	}
	
	
	/***
	 * Validate Customer can add any 25 Dollar Gift item to Cart
	 */
	@Test(priority=2,enabled=true)
	public void AddA25DollarItemInCart() throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.GoTo25DollarGiftCategory();
		ProductListPage TS2 = new ProductListPage(driver,wait);
		TS2.SelectA25$GiftItem(4);
		ProductDetailPage TS3 = new ProductDetailPage(driver, wait);
		TS3.AddTheSelectedProductToCart();
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality Manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-2");
		}
		
	}
	
	/***
	 * Validate Customer can add Multiple sport Items in cart
	 */
	@Test(priority=3,enabled=true)
	public void AddMultipleItemsInCart() throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.GoToSportsCollection();
		ProductListPage TS2 = new ProductListPage(driver,wait);
		TS2.SelectSportsItems(5);
		ProductDetailPage TS3 = new ProductDetailPage(driver, wait);
		TS3.AddMultipleItemInCart(6);
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-3");
		}
		
	}
	
	@DataProvider
	public Object[][] readDataForTestCase4() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario4");
	}
	
	@Test(priority=4,enabled=true,dataProvider="readDataForTestCase4")
	public void LoginToBoonSupply(String UserEmail, String Password) throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.EnterCredentials(UserEmail, Password);
		}
		catch(Exception E){
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-4");
		}
		
	}
	
	@DataProvider
	public Object[][] readDataForTestCase5() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario5");
	}
	
	@Test(priority=5,enabled=true,dataProvider="readDataForTestCase5")
	public void CreateNewAccount(String FirstName, String LastName, String UserEmail, String Password) throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.CreateAnAccount();
		CreateAccountPage TS3 = new CreateAccountPage(driver,wait);
		TS3.CreateNewAccount(FirstName, LastName, UserEmail, Password);
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-5");
		}
				
	}
	
	@DataProvider
	public Object[][] readDataForTestCase6() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario6");
	}
	
	@Test(priority=6,enabled=true,dataProvider="readDataForTestCase6")
	public void UpdateAccountInformation(String UserEmail, String Password, String Street, String City, 
			String State, String zipcode) throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.EnterCredentials(UserEmail, Password);
		TS1.GoToAccountDetails();
		AccountInformationPage TS3 = new AccountInformationPage(driver,wait);
		TS3.UpdateAccountInformation(Street, City, State, zipcode);
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-6");
		}
			
	}
	
	
	@DataProvider
	public Object[][] readDataForTestCase7() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario7");
	}
	
	
	
	@Test(priority=7,enabled=true, dataProvider="readDataForTestCase7")
	public void StartNewFundRaiserWithNewUser(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String firstName, String lastName, String MobNo, String email, String password, String zipCode, String OrgType, 
			String OrgSubType, String City, String State, String FundraiserSize, String FundraiserCatalog, String StartMonth, 
			String StartDate, String EndMonth, String EndDate, String FundraiserType, String WhoIsItFor, String GrpOrInd, 
			String CatalogRequired, String FundraisingFocus) throws Exception {
			try {
				HomePage TS1 = new HomePage(driver, wait);
				CreateFundraiserPage TS2 = new CreateFundraiserPage(driver, wait);
				ChairmanRegistrationPage TS3 = new ChairmanRegistrationPage(driver,wait);
				OrganizationSetupPage TS4 = new OrganizationSetupPage(driver, wait);
				FundraiserInformationPage TS5 = new FundraiserInformationPage(driver, wait);
				TS1.StartAFundraiser();
				if(TS2.CreateFundraiserPageOne(CollectOrderOnPaper, TrackFundraisingParticipants).equalsIgnoreCase("SelectStandard")) {
					TS3.StandardChairmanRegistration(firstName, lastName, MobNo, email, password);
						if(TS4.SearchOrganization(firstName+lastName, zipCode).equalsIgnoreCase("SetupOrganization")) {
							TS4.SetupOrganization(firstName+lastName, OrgType, OrgSubType, firstName, City, City, State, zipCode);
							TS5.FundRaiserInformation(FundraiserSize, FundraiserCatalog, StartMonth, StartDate, EndMonth, EndDate);
							TS5.FundraiserPrograms(FundraiserType);
							TS5.acceptTOSToConfirmFundraiserCreation();
						}
				}else {
					TS3.OnlineChairmanRegistration(firstName, lastName, email, password);
					TS5.SetupOnlineFundRaiserPageOne(firstName+lastName, WhoIsItFor);
					TS5.EnterFundRaiserInfo(firstName, lastName, email, MobNo);
					TS5.EnterFundraiserGoals();
					TS5.FundraiserStyle(GrpOrInd,CatalogRequired);
					TS5.fundraisingFocus(FundraisingFocus);
				}
			}
			catch(Exception E) {
					E.printStackTrace();
					Assert.fail("There is an Exception. Please check the functionality manually.");
					TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-7");
			}
				
	}
	
	//Check for Scenario where there are no fundraiser created due to error
	//Check for scenario where login fails
	
	@DataProvider
	public Object[][] readDataForTestCase8() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario8");
	}
	
	@Test(priority=8,enabled=true,dataProvider="readDataForTestCase8")
	public void CloseFundRaiser(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String Username, String Password) throws Exception {
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.StartAFundraiser();
		CreateFundraiserPage TS2 = new CreateFundraiserPage(driver, wait);
		TS2.CreateFundraiserPageOne(CollectOrderOnPaper, TrackFundraisingParticipants);
		LoggedInUserPage TS3 = new LoggedInUserPage(driver, wait);
		TS3.existingUserSignIn(Username, Password);
		TS3.viewAndCloseFundraiser();
		}
		catch(Exception E) {
			
				E.printStackTrace();
				Assert.fail("There is an Exception. Please check the functionality manually.");
				TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-8");
			
		}
	}
	
	
	@DataProvider
	public Object[][] readDataForTestCase9() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "Scenario9");
	}
	
	@Test(priority=9,enabled=true,dataProvider="readDataForTestCase9")
	public void CancelMyAccount(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String Username, String Password) throws Exception{
		try {
		HomePage TS1 = new HomePage(driver, wait);
		TS1.StartAFundraiser();
		CreateFundraiserPage TS2 = new CreateFundraiserPage(driver, wait);
		TS2.CreateFundraiserPageOne(CollectOrderOnPaper, TrackFundraisingParticipants);
		LoggedInUserPage TS3 = new LoggedInUserPage(driver, wait);
		TS3.existingUserSignIn(Username, Password);
		TS3.CancelMyAccount();
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-9");
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		driver=null;
		wait=null;
	}

}
