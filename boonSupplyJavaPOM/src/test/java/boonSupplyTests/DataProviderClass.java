package boonSupplyTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import Utilities.DataReader;


public class DataProviderClass {
	
	@DataProvider
	public Object[][] LoginToBoonSupplyTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "LoginToBoonSupply");
	}
	
	@DataProvider
	public Object[][] CreateNewAccountTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "CreateNewAccount");
	}
	
	@DataProvider
	public Object[][] UpdateAccountInformationTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "UpdateAccountInformation");
	}
	
	@DataProvider
	public Object[][] CloseFundRaiserTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "CloseFundRaiser");
	}
	
	@DataProvider
	public Object[][] CancelMyAccountTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "CancelMyAccount");
	}
	
	@DataProvider
	public Object[][] StartNewFundRaiserWithNewUserTestData() throws EncryptedDocumentException, IOException {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "StartNewFundRaiserWithNewUser");
	}
	
	@DataProvider
	public Object[][] SearchAFundraiserTestData() throws Exception {
		return DataReader.readExcelData(".//TestData//TestDataBoonSupply.xlsx", "SearchAFundraiser");
	}
	

}
