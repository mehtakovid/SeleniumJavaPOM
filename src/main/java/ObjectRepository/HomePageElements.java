package ObjectRepository;

import org.openqa.selenium.By;

public class HomePageElements {
	
	public By fundraise_widget = By.xpath("//nav[@id='hdrNav']//button[text()='Fundraise']");
	public By findAFundraise = By.xpath("//nav[@id='hdrNav']//h3[contains(text(),'Find a Fundraiser')]");
	public By Shop_Widget = By.xpath("//nav[@id='hdrNav']//button[contains(text(),'Shop')]");
	public By GiftsUnder25$ = By.xpath("//ul[@id='menuShopList']//a[contains(text(),'Gifts Under $25')]");
	public By SportsCollection = By.xpath("//ul[@id='menuShopList']//a[contains(text(),'Sports')]");
	public By LoginIcon = By.xpath("//a[@id='hdrSignInHdrUtils']");
	public By LoggedInIcon = By.xpath("//nav[@id='hdrUtils']/descendant::li[2]");
	public By AccountDetails = By.xpath("//a[contains(text(),'Account')][@class='util-acct__link']");
	public By StartAFundRaiser = By.xpath("//a[contains(text(),'Start a Fundraiser')]");
	
}
