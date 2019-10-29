package boonSupplyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ObjectRepository.CreateFundraiserPageElements;

public class CreateFundraiserPage extends CreateFundraiserPageElements {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public CreateFundraiserPage(WebDriver driver, WebDriverWait wait) {
		CreateFundraiserPage.driver=driver;
		CreateFundraiserPage.wait=wait;
	}
	
	
	public String CreateFundraiserPageOne(String CollectOrderOnPaper, String TrackFundraisingParticipants) {
			if(CollectOrderOnPaper.equalsIgnoreCase("Yes")) {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(CollectOrderOnPaper_Yes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(SelectStandardButton)).click();
				return "SelectStandard";
			}
			else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(CollectOrderOnPaper_No)).click();
					if(TrackFundraisingParticipants.equalsIgnoreCase("Yes")) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(TrackFundraisingParticipants_Yes)).click();;
						wait.until(ExpectedConditions.visibilityOfElementLocated(SelectStandardButton)).click();
						return "SelectStandard";
					}else {
						wait.until(ExpectedConditions.visibilityOfElementLocated(TrackFundraisingParticipants_No)).click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(SelectOnlineOnlyButton)).click();
						return "SelectOnline";
					}
			}
	}
	
	

}
