package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utility.BasePage;

public class Faq extends BasePage {
	
	@Given("^User click on FAQ button$")
	public void user_click_on_FAQ_button() throws Throwable {
	   wrapper.clickWebElement(freq.getuserCLickOnFaqLinkByXpath());
	}

	
	@Given("^User Click on Employer FAQ$")
	public void user_Click_on_Employer_FAQ() throws Throwable {
	    wrapper.clickWebElement(freq.getuserClickOnEmpFaqByXapth());
	}
	
	
	@Given("^User Scroll to the job seeker FAQ$")
	public void user_Scroll_to_the_job_seeker_FAQ() throws Throwable {
	   wrapper.clickInvisibleWebElement(freq.getuserClickOnJobSeekerFaqByXpath());
	}
	
	@When("^User click on FaceBook button$")
	public void user_click_on_FaceBook_button() throws Throwable {
		wrapper.clickInvisibleWebElement(freq.getuserClickFaceBookLinkByXpath());
	}
	
	@Then("^User verify WhizPort FaceBook$")
	public void user_verify_WhizPort_FaceBook() throws Throwable {
	   System.err.println(freq.getfaceBookTitleByXpath().getText());
	   Assert.assertTrue(freq.getfaceBookTitleByXpath().isDisplayed());
	   Assert.assertEquals("Facebook", freq.getfaceBookTitleByXpath().getText().trim());
	   wrapper.getEmbedScreenShot();
	}

}
