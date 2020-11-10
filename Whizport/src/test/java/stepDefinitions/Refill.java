package stepDefinitions;

import cucumber.api.java.en.Given;
import utility.BasePage;

public class Refill extends BasePage{
	
	
	
	@Given("^User click Refill Medication$")
	public void user_click_Refill_Medication() throws Throwable {
		wrapper.clickInvisibleWebElement(refill.getuserClickRefillMedByXpath());
	    
	}

//	@Given("^User click Request Refills button$")
//	public void user_click_Request_Refills_button() throws Throwable {
//	   
//	}
//
//	@Given("^User scroll down by '(\\d+)'$")
//	public void user_scroll_down_by(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Given("^User click on checkbox$")
//	public void user_click_on_checkbox() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^User click on Next button$")
//	public void user_click_on_Next_button() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^User see different page$")
//	public void user_see_different_page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}

	

}
