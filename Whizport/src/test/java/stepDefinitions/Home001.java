package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BasePage;

public class Home001 extends BasePage {
	
	
	
	@When("^User click on linkText Hire From Software Testers Pool$")
	public void user_click_on_linkText_Hire_From_Software_Testers_Pool() throws Throwable
	
	{
		wrapper.clickWebElement(home001.getuserClickOnHireFromSoftwareTestersPoolByXpath());
		 wrapper.navigateBack();
	}
	
	
	
	@When("^User click on Join Our Software Testers Pool link$")
	public void user_click_on_Join_Our_Software_Testers_Pool_link() throws Throwable
	
	{
		wrapper.clickWebElement(home001.getuserClickOnJoinOurSoftwareTesterPoolByPartialLinkText());
		 wrapper.navigateBack();
	}

	
	
	@When("^User click on arrow link$")
	public void user_click_on_arrow_link() throws Throwable 
	
	{
		wrapper.clickWebElement(home001.getuserClickOnArrowLinkByXpath());
		
//		Actions actions = new Actions(driver);
//		//WebElement elementLocator = driver.findElement(By.id("ID"));
//		actions.doubleClick(home001.getuserClickOnArrowLinkByXpath()).build().perform();
	
	}
	
	

	@When("^User click on Join Us link$")
	public void user_click_on_Join_Us_link() throws Throwable 
	
	{
	   wrapper.clickWebElement(home001.getuserClickOnJoinUsLinkByXpath());
	   wrapper.scrollingInThePageByPixels(600);
	}


	
	
//	@When("^User click on Number link$")
//	public void user_click_on_Number_link() throws Throwable
//	
//	{
//		wrapper.clickWebElement(home001.getuserClickOnNumberLinkByXpath());
//		wrapper.acceptAlertPopUp();
//		wrapper.getEmbedScreenShot();
//		
//   	}

	
	
	@When("^User click on Facebook link$")
	public void user_click_on_Facebook_link() throws Throwable 

	{
		wrapper.clickInvisibleWebElement(home001.getuserClickOnFaceBookLinByXpath());
		 wrapper.navigateBack();
		 Thread.sleep(5000);
 	}

	
	
	
	
	@When("^User click on Twitter link$")
	public void user_click_on_Twitter_link() throws Throwable 
	
	{
		   wrapper.clickWebElement(home001.getuserClickOnTwitterLinkByXpath());
			 wrapper.navigateBack();

	}
	
	@When("^User click on linked link$")
	public void user_click_on_linked_link() throws Throwable 
	
	{
		wrapper.clickWebElement(home001.getuserClickOnLinkedByXpath());
		 //wrapper.navigateBack();
	}
	
	
	
	@Then("^User verfiy above steps$")
	public void user_verfiy_above_steps() throws Throwable 
	
	{
	    System.out.println(wrapper.getCurrentUrl());
	    wrapper.navigateBack();  
	}



}	    

