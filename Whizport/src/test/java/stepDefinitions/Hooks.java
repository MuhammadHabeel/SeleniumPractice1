package stepDefinitions;

import java.io.IOException;
import java.sql.SQLException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.BasePage;
import utility.BrowserSetUp;

import utility.Wrapper;

public class Hooks extends BasePage {


	@Before
	public static void beforeAllTestStart(Scenario scenario)throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		
		browser = new BrowserSetUp(BasePage.driver);/* Pass WebDriver to the BrowserSetUp class */

		if (scenario.getName().contains("Front-end"))
			{
			
			System.out.println("Front-end testing now...");
			driver = browser.openBrowser();/* start browser */

			} 
			else if (scenario.getName().contains("Database Test"))
			{

			System.out.println("Database testing now...");
			DatabaseManager.createConnection();
			
			} 
			 else 
			 {

			System.out.println("Please tag your scenario name with one of following ('Front-end' and 'Database Test') to run script.");

			 }
		
		
		wrapper = new Wrapper(BasePage.driver); /* pass driver to wrapper class */

		
		//This is the configuration for running the test for Demo or not for demo
		if (BasePage.configProperty.readProperty("demoMode").contains("true")) {

			wrapper.isDemoMode = true;
			System.out.println("");
			System.out.println("Test is running Demo mode = ON ...");

		} else

		{
			System.out.println("");
			System.out.println("Test is running Demo mode = OFF ...");

		}

		//This is printing the scenario name in the console at the beginning of the test.
		System.out.println("-----------------------------------------------");
		System.out.println("Starting Scenario - " + " " + scenario.getName());
		System.out.println("-----------------------------------------------");

	}

	@After
	public static void tearDown(Scenario scenario) throws Exception {
		//This is printing the scenario name in the console at the end of the test.
		System.out.println("-----------------------------------------------");
		System.out.println("Ending Scenario -  Status As - " + scenario.getStatus());
		System.out.println("-----------------------------------------------");

		//This is used to check after each scenario and if the scenario is failed or skipped or undefine, 
		//or pending will take screen shoot and attached in the report.
		try {
			
			if (scenario.getStatus() == "failed" || scenario.getStatus() == "skipped"
					|| scenario.getStatus() == "undefined" || scenario.getStatus() == "pending") {

				wrapper.getEmbedScreenShot();

				driver.quit();

			}
		} catch (Exception e) {
			Reporter.addStepLog(e.getMessage());
		}

	

		if (scenario.getName().contains("Database Test")) {
			// do nothing
		}else {

			 if(driver!=null) {
				 driver.quit();
			 }
		}

	}

}
