package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BasePage;

public class MyACPNY extends BasePage{
	
	
	@Given("^User highlight username field$")
	public void user_highlight_username_field() throws Throwable {
		wrapper.elementHighlight(portal.getuserHighLightUsernameFieldByXpath());
	    
	}
	
	
	@Given("^User write 'Hazrat@(\\d+)'$")
	public void user_write_Hazrat(int arg1) throws Throwable {
	   wrapper.enterTextField(portal.getuserHighLightUsernameFieldByXpath(), "hazrat");
	}
	
	
	@Given("^User write '\"([^\"]*)\"'$")
	public void user_write(String arg1) throws Throwable {
	    wrapper.enterTextField(portal.getuserSendPasswordByXpath(), "Hazrat@123");
	}
	
	@When("^User clicks on Sign in button$")
	public void user_clicks_on_Sign_in_button() throws Throwable {
	    wrapper.clickWebElement(portal.getuserClickOnSignInButton());
	}
	
	@Then("^User land to Advantage Care Physician page$")
	public void user_land_to_Advantage_Care_Physician_page() throws Throwable {
	    
	}



}
