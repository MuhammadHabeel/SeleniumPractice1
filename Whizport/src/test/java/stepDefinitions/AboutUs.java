package stepDefinitions;

import com.google.common.base.Equivalence.Wrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BasePage;

public class AboutUs extends BasePage{
	
	
	@Given("^User click on ABOUT US button$")
	public void user_click_on_ABOUT_US_button() throws Throwable 
	
	{
		wrapper.clickWebElement(about.getclickOnAboutUsByXpath());
		wrapper.getCurrentUrl();	   
	}
	

	
	
	@When("^User mouse hover on picture$")
	public void user_mouse_hover_on_picture() throws Throwable 
	{
		wrapper.moveMouseToElementAndClickIt(about.getmouseHoverOnOurByXpath());
		wrapper.getEmbedScreenShot(); 
		
	}

	



}
