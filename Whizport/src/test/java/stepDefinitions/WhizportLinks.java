package stepDefinitions;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utility.BasePage;

public class WhizportLinks extends BasePage {
	
	
	
	
	@Given("^I navigate to the Application$")
	public void i_navigate_to_the_Application() throws Throwable
	
	
	{
	    driver.get(configProperty.readProperty("ApplicationTestURL"));
	    wrapper.waitForPageToBeFullyLoaded(driver);
	}
	
	

    @When("^I fetch all the Whizport Links$")
	public void i_fetch_all_the_Whizport_Links() throws Throwable 
	
	
	{		
		//just the below code will give me all links and images exists in Whizport Application
		wrapper.collectlinksList("a", "href");
		wrapper.getEmbedScreenShot();
	}
	
	
	
	@Then("^I check broken links$")
	public void i_check_broken_links() throws Throwable 
	
	
	{
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		
		wrapper.clickWebElement(menu.getWhizportaboutUsByXpath());
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		Reporter.addStepLog(menu.getWhizportaboutUsByXpath().getText());
		
		
		wrapper.clickWebElement(menu.getWhizportcontactUsByXpath());
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		Reporter.addStepLog(menu.getWhizportcontactUsByXpath().getText());
		
		
		wrapper.clickWebElement(menu.getWhizportfaqByXpath());
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		Reporter.addStepLog(menu.getWhizportfaqByXpath().getText());
		
		
		wrapper.clickWebElement(menu.getWhizportCareerByXpath());
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		Reporter.addStepLog(menu.getWhizportCareerByXpath().getText());
		Thread.sleep(30000);
		
		
		wrapper.clickWebElement(menu.getWhizportourServicesByXpath());
		wrapper.checkBrokenLink("a","href");
		wrapper.checkBrokenLink("img", "src");
		Reporter.addStepLog(menu.getWhizportourServicesByXpath().getText());
		
		
		if (wrapper.checkError) {
			Assert.assertTrue(false);
		} else {
			// do nothing
		}

		
		
	}



}
