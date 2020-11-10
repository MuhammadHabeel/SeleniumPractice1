package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utility.BasePage;

public class Service extends BasePage{
	
	
	@When("^User click on our services$")
	public void user_click_on_our_services() throws Throwable {
	    wrapper.clickWebElement(Serve.getclickOnServiceByXpath());
	}
	
	
	@When("^User click on facebook link$")
	public void user_click_on_facebook_link() throws Throwable {
	    wrapper.clickWebElement(Serve.getclickOnFaceBookByXpath());
	}
	
	
	
	@Then("^User verify Whizport on facebook site$")
	public void user_verify_Whizport_on_facebook_site() throws Throwable {
	    
		
		System.out.println(Serve.getfaceBookTitleByXpath().getText());
		Assert.assertTrue(Serve.getfaceBookTitleByXpath().isDisplayed());
	   Assert.assertEquals("Facebook", Serve.getfaceBookTitleByXpath().getText().trim());
	   wrapper.getEmbedScreenShot();
	}



}
