package boonSupplyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.TakeAScreenshot;
import boonSupplyPage.AccountInformationPage;
import boonSupplyPage.ChairmanRegistrationPage;
import boonSupplyPage.CheckOutPage;
import boonSupplyPage.CreateAccountPage;
import boonSupplyPage.CreateFundraiserPage;
import boonSupplyPage.FundRaiserCategoryPage;
import boonSupplyPage.FundraiserInformationPage;
import boonSupplyPage.HomePage;
import boonSupplyPage.LoggedInUserPage;
import boonSupplyPage.LoginPage;
import boonSupplyPage.OrganizationSetupPage;
import boonSupplyPage.ProductDetailPage;
import boonSupplyPage.ProductListPage;

public class TestRunner extends BaseConfigurationClass {
	
	@Test(priority=1,enabled=false, dataProvider="StartNewFundRaiserWithNewUserTestData",dataProviderClass=DataProviderClass.class,groups= {"Regression"})
	public void StartNewFundRaiserWithNewUser(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String firstName, String lastName, String MobNo, String email, String password, String zipCode, String OrgType, 
			String OrgSubType, String City, String State, String FundraiserSize, String FundraiserCatalog, String StartMonth, 
			String StartDate, String EndMonth, String EndDate, String FundraiserType, String WhoIsItFor, String GrpOrInd, 
			String CatalogRequired, String FundraisingFocus) throws Exception {
			try {
				logger = extent.startTest("StartNewFundRaiserWithNewUser");
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
							logger.log(LogStatus.PASS, "StartNewFundRaiserWithNewUser Test Passed Successfully.");
						}
				}else {
					TS3.OnlineChairmanRegistration(firstName, lastName, email, password);
					TS5.SetupOnlineFundRaiserPageOne(firstName+lastName, WhoIsItFor);
					TS5.EnterFundRaiserInfo(firstName, lastName, email, MobNo);
					TS5.EnterFundraiserGoals();
					TS5.FundraiserStyle(GrpOrInd,CatalogRequired);
					TS5.fundraisingFocus(FundraisingFocus);
					logger.log(LogStatus.PASS, "StartNewFundRaiserWithNewUser Test Passed Successfully.");
				}
			}
			catch(Exception E) {
					E.printStackTrace();
					Assert.fail("There is an Exception. Please check the functionality manually.");
					TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-7");
					logger.log(LogStatus.FAIL, "StartNewFundRaiserWithNewUser Test Failed.");
			}
				
	}
	
	@Test(priority=2,dataProvider="LoginToBoonSupplyTestData",dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void LoginToBoonSupply(String UserEmail, String Password) throws Exception {
		try {
		logger = extent.startTest("LoginToBoonSupply");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.EnterCredentials(UserEmail, Password);
		logger.log(LogStatus.PASS, "LoginToBoonSupply Test Passed Successfully.");
		}
		catch(Exception E){
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-4");
			logger.log(LogStatus.FAIL, "LoginToBoonSupply Test Failed.");
		}
		
	}
	
	
	@Test(priority=3,enabled=true,dataProvider="CreateNewAccountTestData",dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void CreateNewAccount(String FirstName, String LastName, String UserEmail, String Password) throws Exception {
		try {
		logger = extent.startTest("CreateNewAccount");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.CreateAnAccount();
		CreateAccountPage TS3 = new CreateAccountPage(driver,wait);
		TS3.CreateNewAccount(FirstName, LastName, UserEmail, Password);
		logger.log(LogStatus.PASS, "CreateNewAccount Test Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-5");
			logger.log(LogStatus.FAIL, "CreateNewAccount Test Failed.");
		}
				
	}
	
	
	@Test(priority=4,enabled=true,dataProvider="UpdateAccountInformationTestData",dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void UpdateAccountInformation(String UserEmail, String Password, String Street, String City, 
			String State, String zipcode) throws Exception {
		try {
		logger = extent.startTest("UpdateAccountInformation");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnLogin();
		LoginPage TS2 = new LoginPage(driver,wait);
		TS2.EnterCredentials(UserEmail, Password);
		TS1.GoToAccountDetails();
		AccountInformationPage TS3 = new AccountInformationPage(driver,wait);
		TS3.UpdateAccountInformation(Street, City, State, zipcode);
		logger.log(LogStatus.PASS, "UpdateAccountInformation Test Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-6");
			logger.log(LogStatus.FAIL, "UpdateAccountInformation Test Failed.");
		}
			
	}
	
	@Test(priority=5,enabled=false,dataProvider="CloseFundRaiserTestData",dataProviderClass=DataProviderClass.class,groups= {"Regression"})
	public void CloseFundRaiser(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String Username, String Password) throws Exception {
		try {
		logger = extent.startTest("CloseFundRaiser");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.StartAFundraiser();
		CreateFundraiserPage TS2 = new CreateFundraiserPage(driver, wait);
		TS2.CreateFundraiserPageOne(CollectOrderOnPaper, TrackFundraisingParticipants);
		LoggedInUserPage TS3 = new LoggedInUserPage(driver, wait,logger);
		TS3.existingUserSignIn(Username, Password);
		TS3.viewAndCloseFundraiser();
		logger.log(LogStatus.PASS, "CloseFundRaiser Test Passed Successfully.");
		}
		catch(Exception E) {
				E.printStackTrace();
				Assert.fail("There is an Exception. Please check the functionality manually.");
				TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-8");
				logger.log(LogStatus.FAIL, "CloseFundRaiser Test Failed.");
			
		}
	}
	
	
	
	@Test(priority=6,enabled=false,dataProvider="CancelMyAccountTestData",dataProviderClass=DataProviderClass.class, groups= {"Regression"})
	public void CancelMyAccount(String CollectOrderOnPaper, String TrackFundraisingParticipants, 
			String Username, String Password) throws Exception{
		try {
		logger = extent.startTest("CancelMyAccount");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.StartAFundraiser();
		CreateFundraiserPage TS2 = new CreateFundraiserPage(driver, wait);
		TS2.CreateFundraiserPageOne(CollectOrderOnPaper, TrackFundraisingParticipants);
		LoggedInUserPage TS3 = new LoggedInUserPage(driver, wait,logger);
		TS3.existingUserSignIn(Username, Password);
		TS3.CancelMyAccount();
		logger.log(LogStatus.PASS, "CancelMyAccount Test Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-9");
			logger.log(LogStatus.FAIL, "CancelMyAccount Test Failed.");
		}
	}
	
	

	
	@Test(priority=7,enabled=true,dataProvider="SearchAFundraiserTestData",dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void SearchAFundraiser(String SearchKeyword) throws Exception {
		try {
		logger = extent.startTest("SearchAFundraiser");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.ClickOnFindAFundRaiser();
		FundRaiserCategoryPage TS2 = new FundRaiserCategoryPage(driver, wait);
		TS2.SearchTheFundRaiser(SearchKeyword);
		logger.log(LogStatus.PASS, "Search FundRaiser Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality Manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-1");
			logger.log(LogStatus.FAIL, "Search FundRaiser Failed.");
		}
		
	}
	
	
	@Test(priority=8,enabled=true,dataProvider="SearchAFundraiserTestData",dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void getTheNumberOfFundraiser(String SearchKeyword) throws Exception {
		try {
			logger = extent.startTest("getTheNumberOfFundraiser");
			HomePage TS1 = new HomePage(driver, wait);
			TS1.ClickOnFindAFundRaiser();
			FundRaiserCategoryPage TS2 = new FundRaiserCategoryPage(driver, wait);
			TS2.SearchTheFundRaiser(SearchKeyword);
			TS2.FindTheNumberOfFundraisersReturned();
			logger.log(LogStatus.PASS, "Get The Number Of Fundraiser Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality Manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-1");
			logger.log(LogStatus.FAIL, "Get The Number Of Fundraiser Failed.");
		}
	}
	
	
	@Test(priority=9,enabled=true,dataProviderClass=DataProviderClass.class,groups= {"Sanity","Regression"})
	public void GetFeaturedFundRaisers() throws Exception {
		try {
		logger = extent.startTest("GetFeaturedFundRaisers");
		HomePage TS1 = new HomePage(driver,wait);
		TS1.FindFeaturedFundraisers();
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception.Please check the functionality.");
			TakeAScreenshot.CaptureScreenshot(driver, ".//test-output//Screenshots//TestCase-1");
			logger.log(LogStatus.FAIL, "Get Featured FundRaisers Test Failed.");
		}
	}
	
	@Test(priority=10,enabled=true,dataProviderClass=DataProviderClass.class,groups= {"Regression","Sanity"})
	public void AddA25DollarItemInCart() throws Exception {
		try {
		logger = extent.startTest("AddA25DollarItemInCart");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.GoTo25DollarGiftCategory();
		ProductListPage TS2 = new ProductListPage(driver,wait);
		TS2.SelectA25$GiftItem(4);
		ProductDetailPage TS3 = new ProductDetailPage(driver, wait);
		TS3.AddTheSelectedProductToCart();
		logger.log(LogStatus.PASS, "Add a 25$ Item Test Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality Manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-2");
			logger.log(LogStatus.FAIL, "Add a 25$ Item Test Failed.");
		}	
	}
	
	/***
	 * Validate Customer can add Multiple sport Items in cart
	 */
	@Test(priority=11,enabled=true,dataProviderClass=DataProviderClass.class,groups= {"Regression","Sanity"})
	public void AddMultipleItemsInCart() throws Exception {
		try {
		logger = extent.startTest("AddMultipleItemsInCart");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.GoToSportsCollection();
		ProductListPage TS2 = new ProductListPage(driver,wait);
		TS2.SelectSportsItems(5);
		ProductDetailPage TS3 = new ProductDetailPage(driver, wait);
		TS3.AddMultipleItemInCart(6);
		logger.log(LogStatus.PASS, "AddMultipleItemsInCart Test Passed Successfully.");
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-3");
			logger.log(LogStatus.FAIL, "AddMultipleItemsInCart Test Failed.");
		}
		
	}
	
	@Test(priority=12,enabled=true,dataProviderClass=DataProviderClass.class,groups= {"Regression"})
	public void ValidateCheckoutPageFeatures() throws Exception {
		try {
			logger = extent.startTest("AddMultipleItemsInCart");
			HomePage TS1 = new HomePage(driver, wait);
			TS1.GoToSportsCollection();
			ProductListPage TS2 = new ProductListPage(driver,wait);
			TS2.SelectSportsItems(5);
			ProductDetailPage TS3 = new ProductDetailPage(driver, wait);
			TS3.AddMultipleItemInCart(6);
			TS3.ClickOnCheckoutButtonInCart();
			CheckOutPage TS4 = new CheckOutPage(driver, wait);
			TS4.ValidatePricingOnCheckoutPage();
			logger.log(LogStatus.PASS, "Validate CheckoutPage Features Test Passed Successfully.");
			}
			catch(Exception E) {
				E.printStackTrace();
				Assert.fail("There is an Exception. Please check the functionality manually.");
				TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-3");
				logger.log(LogStatus.FAIL, "Validate CheckoutPage Features Test Failed.");
			}
	}
	
	@Test(priority=13, enabled=true,dataProviderClass=DataProviderClass.class,groups= {"Regression","Sanity"})
	public void GetTrendingItemsforShopping() throws Exception {
		try {
		logger = extent.startTest("GetTrendingItemsforShopping.");
		HomePage TS1 = new HomePage(driver, wait);
		TS1.GetTrendingItems();
		}
		catch(Exception E) {
			E.printStackTrace();
			Assert.fail("There is an Exception. Please check the functionality manually.");
			TakeAScreenshot.CaptureScreenshot(driver,".//test-output//Screenshots//TestCase-3");
			logger.log(LogStatus.FAIL, "Get Trending Items for Shopping test Failed.");
		}
	}
	

}
