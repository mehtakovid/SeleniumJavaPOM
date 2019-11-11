package ObjectRepository;

import org.openqa.selenium.By;

public class OrganizationSetupPageElements {
	
	//SearchyourOrganization
		public By OrganizationName = By.xpath("//input[@id='name']");
		public By OrganizationZipCode = By.xpath("//input[@ng-model='zip']");
		public By SearchOrganization = By.xpath("//button[text()='SEARCH ORGANIZATIONS']");
		
		//SetupYourOrganization
		public By CreateYourOrganization_header = By.xpath("//h2[text()='Create Your Organization']");
		public By Setup_OrganizationName = By.xpath("//input[@id='organization_name']");
		public By Setup_OrganizationType = By.xpath("//div[@id='s2id_organization_organization_type_id']");
		public By Select_OrganizationType = By.xpath("//select[@id='organization_organization_type_id']");
		public By Setup_SchoolType = By.xpath("//div[@title='School type']");
		public By Select_SchoolType = By.xpath("//select[@id='organization_school_type_id']");
		public By Setup_Addresse = By.xpath("//input[@id='organization_addresses_attributes_0_addressee']");
		public By Setup_Address = By.xpath("//input[@id='organization_addresses_attributes_0_address1']");
		public By Setup_Address2 = By.xpath("//input[@id='organization_addresses_attributes_0_address2']");
		public By Setup_City = By.xpath("//input[@id='organization_addresses_attributes_0_city']");
		public By Setup_State = By.xpath("//div[@id='s2id_organization_addresses_attributes_0_state']");
		public By Select_State = By.xpath("//select[@id='organization_addresses_attributes_0_state']");
		public By Setup_ZipCode = By.xpath("//input[@id='organization_addresses_attributes_0_zipcode']");
		public By CreateOrganizationButton = By.xpath("//input[@value='Create Organization']");
		public By FundraiserInformationHeader = By.xpath("//h2[text()='Fundraiser Information']");

}
