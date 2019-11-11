package ObjectRepository;

import org.openqa.selenium.By;

public class FundraiserInformationPageElements {

	//FundraiserInformation
		public By FundraiserSize = By.xpath("//input[@id='fundraiser_estimated_member_count']");
		public By NumberOfCatalogsNeeded = By.xpath("//input[@id='fundraiser_potential_participants']");
		public By FundraiserStartDate = By.xpath("//input[@id='fundraiser_start_date']");
		public By MonthandYear = By.xpath("//div[@class='ui-datepicker-title']");
		public By NextMonth = By.xpath("//a[@data-handler='next']");
		public By FundraiserEndDate = By.xpath("//input[@id='fundraiser_end_date']");
		public By nextButton_fundraiserInformation = By.xpath("//input[@value='NEXT']");
		public By FundraiserProgramHeader = By.xpath("//h2[text()='Fundraiser Programs']");
		
		
		//FundraiserProgram
		public By CatalogFundraiser_RadioButton = By.xpath("//div[@class='fundraiser-type-select']//input[@value='Catalog & Online Fundraiser']");
		public By OnlineOnly_RadioButton = By.xpath("//div[@class='fundraiser-type-select']//input[@value='Online Only']");
		public By NoAddOns_RadioButton = By.xpath("//div[@class='fundraiser-addon-select']//input[@value='Catalog & Online Fundraiser']");
		public By FullService_RadioButton = By.xpath("//div[@class='fundraiser-addon-select']//input[@value='Full Service - $150']");
		public By NextButton_FundraiserProgram = By.xpath("//input[@value='NEXT']");
		
		//TOSPage
		public By TOSAgreeButton = By.xpath("//button[text()='AGREE']");
		
		public By SuccessMessage = By.xpath("//div[@id='flash_notice']");
		public By FundRaiserName = By.xpath("//div[@class='pull-left']/h2");
		public By FundraiserDate = By.xpath("//div[@class='pull-left']/p[2]");
		
		
		
		//OnlineFundraiser
		public By Online_FundRaiserName = By.tagName("textarea");
		public By Who_is_it_For = By.xpath("//input[@placeholder='Who is it for?']");
		public By NextButton = By.xpath("//button[contains(text(),'Next')]");
		
		//Fundraiser Information
		public By fundContactName = By.xpath("//textarea[@id='fundContactName']");
		public By fundContactLastName = By.xpath("//textarea[@id='fundContactLastName']");
		public By fundAddress = By.xpath("//input[@id='fundAddress']");
		public By fundEmail = By.xpath("//input[@id='fundEmail']");
		public By fundPhone = By.xpath("//input[@id='fundPhone']");
		public By NotWorkingwithAnyConsultants = By.xpath("//label[@for='consultantValNo']");
		
		//Fundraiser Goal
		public By No_goalAtThisTime = By.xpath("//label[@for='hasGoalNo']");
		public By No_earningsVisible = By.xpath("//label[@for='showEarningsNo']");
		public By StartDate = By.xpath("//input[@placeholder='Start Date']");
		public By StartDateOption_StartNow = By.xpath("//ul[@id='ssDropdown']/li[contains(text(),'Start Now')]");
		public By EndDate = By.xpath("//input[@placeholder='End Date']");
		public By EndDateOption_EndIn1week = By.xpath("//ul[@id='ssDropdown']/li[contains(text(),'1 Week')]");
		
		
		//Fundraiser Style
		public By fundraiserStyle_individual = By.xpath("//label[@for='individual']");
		public By No_CatalogeRequired = By.xpath("//label[@for='catalogsNo']");
		public By Yes_CatalogeRequired = By.xpath("//label[@for='catalogsYes']");
		public By fundraiserStyle_Group = By.xpath("//label[@for='group']");

		//Fundraiser Focus
		public By FundrasingFocusHeader = By.xpath("//h3[text()='What is your fundraising focus?']");
		public By CustomizeMyFundraiser = By.xpath("//button[contains(text(),'Customize My Fundraiser')]");
		public By ReadyToLaunchText = By.xpath("//p[contains(text(),'ready to launch')]");





}
