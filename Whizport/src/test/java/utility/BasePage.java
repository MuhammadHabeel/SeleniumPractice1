package utility;

import java.io.File;

import org.assertj.core.api.SoftAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;

import pages.AboutUsPage;
import pages.CareerPages;
import pages.ContactUsPage;
import pages.FaqPage;
import pages.GenImagePage;
import pages.Home001Page;
import pages.HomePage;
import pages.MyAcpnyPage;
import pages.RefillPage;
import pages.RequestTalentPage;
import pages.WhizportMenu;
import pages.ServicePage;
import pages.WhizportLinksPage;







public class BasePage {

	
	//################################################		
	//# 										 	 # 
	//# 				Page Objects		         #
	//# 										 	 # 
	//################################################

	public static final WhizportMenu 		Menu       =   new WhizportMenu();
	public static final HomePage 		    home       =   new HomePage();
	public static final RequestTalentPage   talent     =   new RequestTalentPage();
	public static final AboutUsPage 		about      =   new AboutUsPage();
	public static final ServicePage 		Serve      =   new ServicePage();
	public static final FaqPage 			freq       =   new FaqPage();
	public static final ContactUsPage 		Contact    =   new ContactUsPage();
	public static final MyAcpnyPage 		portal     =   new MyAcpnyPage();
	public static final RefillPage 			refill     =   new RefillPage();
	public static final WhizportMenu 		menu       =   new WhizportMenu();
	public static final Home001Page 		home001    =   new Home001Page();
	public static final GenImagePage 		image      =   new GenImagePage();
	public static final WhizportLinksPage 	links      =   new WhizportLinksPage();
	public static final CareerPages 		career     =   new CareerPages();

	
	


	// ################################################
	// # 											  #
	// #			   utility Objects                #
	// # 											  #
	// ################################################
	


	public static WebDriver driver;
	public static Wrapper wrapper;
	public static ConfigFileReader configProperty;
	public static BrowserSetUp browser;
	public static final ProjectSpecificSupportFunctions NLMSupportFunctions=new ProjectSpecificSupportFunctions();
	public static DatabaseManager DatabaseManager = new DatabaseManager();
	


	// ################################################
	// # 											  #
	// # 			Class Configuration               #
	// # 											  #
	// ################################################

	

	
	
	
	@BeforeClass
	public static void beforeAllTestStart() {

		configProperty = new ConfigFileReader("config.properties");
		
	
			
	  
	}
		
		
		
	

	@AfterClass
	public static void afterAllTestsComplete(){

		 Reporter.loadXMLConfig(new File(configProperty.readProperty("reportConfigPath")));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		 Reporter.setSystemInfo("OS Name", System.getProperty("os.name"));
		 Reporter.setSystemInfo("OS Version", System.getProperty("os.version"));
		 Reporter.setSystemInfo("Application", configProperty.readProperty("ApplicationName"));
		 Reporter.setSystemInfo("Application", "SourceVu");
		 Reporter.setSystemInfo("Application Environment", System.getProperty("environmentT"));
		 Reporter.setSystemInfo("Build number", System.getProperty("jenkins.buildNumber"));
		 Reporter.setSystemInfo("Browser Type", browser.browserName);
	
			
	
		 if(driver!=null) {
			 driver.quit();
		 }
			

		
	}


}
