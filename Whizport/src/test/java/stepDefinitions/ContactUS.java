package stepDefinitions;

import cucumber.api.java.en.Given;
import utility.BasePage;

public class ContactUS extends BasePage {
	
	
	@Given("^User move the mouse to Contact Us link$")
	public void user_move_the_mouse_to_Contact_Us_link() throws Throwable {
		
		wrapper.moveMouseToElement(Contact.getuserMoveMouseToContactUsButtonByXpath());
		
		
	    	}
	
	
	@Given("^User click on Request Talent$")
	public void user_click_on_Request_Talent() throws Throwable {
	   wrapper.clickInvisibleWebElement(Contact.getuserClickOnReqTalentByXpath());
	}


	

//	@Given("^User click on upload resume$")
//	public void user_click_on_upload_resume() throws Throwable {
//		wrapper.clickWebElement(Contact.getuserClickOnUploadResumeByCss());
//    
//}


}
