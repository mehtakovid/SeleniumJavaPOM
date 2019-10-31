package boonSupplyTests;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseConfigurationClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	 public void startReport(){
	 extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/BoonSupplyReport.html", true);
	 extent
	                .addSystemInfo("Host Name", "BoonSupply")
	                .addSystemInfo("Environment", "Production")
	                .addSystemInfo("User Name", "Kovid Mehta");
	                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
	                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
	                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }
	
	@BeforeMethod
	public void DriverInitialization() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://www.boonsupply.com/");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	

	@AfterMethod
	public void teardown() {
		extent.endTest(logger);
		driver.quit();
		driver=null;
		wait=null;
	}
	
	@AfterSuite
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
    }
}

