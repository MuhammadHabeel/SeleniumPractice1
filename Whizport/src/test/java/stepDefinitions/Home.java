package stepDefinitions;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import utility.BasePage;

public class Home extends BasePage{
	
	@Given("^User navigate on application$")
	public void user_navigate_on_application() throws Throwable {
		
		driver.get(configProperty.readProperty("ApplicationTestURL"));
		wrapper.waitForPageToBeFullyLoaded(driver);
		
	   
	}
	
	@Given("^User Scroll Veritically by '(\\d+)'$")
	public void user_Scroll_Veritically_by(int arg1) throws Throwable {
		wrapper.scrollingInThePageByPixels(arg1);
		
	   
	}
	
	
	

	@When("^User Click on Hire from software testers pool button$")
	public void user_Click_on_Hire_from_software_testers_pool_button() throws Throwable {
		
		wrapper.clickWebElement(home.getHireFromTestersPool());
		
	    
	}

	
	
	@Then("^User see Request Talent Page$")
	public void user_see_Request_Talent_Page() throws Throwable {
		System.out.println(talent.getRequestTalentTitleByXpath().getText());
		Assert.assertTrue(talent.getRequestTalentTitleByXpath().isDisplayed());
	   Assert.assertEquals("REQUEST TALENT", talent.getRequestTalentTitleByXpath().getText().trim());
	   wrapper.getEmbedScreenShot();
	}
	
	
	
	
	

}
