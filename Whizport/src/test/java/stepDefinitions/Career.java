package stepDefinitions;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utility.BasePage;

public class Career extends BasePage{

	
	
	
	@Given("^I click on Career Menu Link$")
	public void i_click_on_Career_Menu_Link()      throws Throwable 
	
	
	{
	   wrapper.clickWebElement(menu.getWhizportCareerByXpath());
		Thread.sleep(10000);

	}
	
	
	
	@Given("^I enter to the edit box '\"([^\"]*)\"'$")
	public void i_enter_to_the_edit_box(String arg1) throws Throwable 
	
	
	{
		Thread.sleep(10000);
		wrapper.enterTextField(career.getIEnterSoftwareManagerInEditBoxByXpath(), "Software QA Manager");
	}
//	@Given("^I enter to the edit box '\"([^\"]*)\"'$")
//	public void i_enter_to_the_edit_box(String arg1) throws Throwable 
//	
//	
//	{
//		wrapper.enterTextField(career.getIEnterSoftwareManagerInEditBoxByXpath(), "Software QA Manager");
//	}
//	
	
	
	@Given("^I click on Search link$")
	public void i_click_on_Search_link() throws Throwable
	
	
	{
	   	wrapper.clickWebElement(career.getIClickOnSearchLinkByXpath());
	}
	
	
	@Given("^I click Software QA Manager \\(Multiple Options\\)$")
	public void i_click_Software_QA_Manager_Multiple_Options() throws Throwable
	
	
	{
	   wrapper.clickWebElement(career.getIClickOnSoftwareManagerLinkByXpath());
	}
	
	
	@Given("^I click on Apply image link$")
	public void i_click_on_Apply_image_link() throws Throwable 
	
	
	{
	    wrapper.clickWebElement(career.getIClickOnApplyLinkByXpath());
	}
	
	
	
	@Given("^I enter in the edit box '\"([^\"]*)\"'$")
	public void i_enter_in_the_edit_box(String arg1) throws Throwable 
	
	{
		 wrapper.enterTextField(career.getIEnterMyFullNameByXpath(), "Muhammad Habeel Hazrat");
	}
	
	
	
	@Given("^I enter my email address '\"([^\"]*)\"'$")
	public void i_enter_my_email_address(String arg1) throws Throwable 
	
	
	{
		wrapper.enterTextField(career.getIEnterMyEmailAddressByXpath(), "te.fnuqais@gmail.com"); 
	}
	
	
	
	
	@Given("^I enter '<My Phone Number>'my phone number '<My Phone Number>'$")
	public void i_enter_My_Phone_Number_my_phone_number_My_Phone_Number() throws Throwable 
	
	
	{
		wrapper.enterTextField(career.getIEnterMyPhoneNumberByXpath(), "6468069973");
	}
	
	    
	    
	@Given("^I click upload my resume$")
	public void i_click_upload_my_resume() throws Throwable 
	
	
	{
	   wrapper.fileUpload(career.getIClickOnUploadResumeByXpath(), "C:\\Users\\MOHAMMAD KAMAL(QAIS)\\Desktop\\Muhammad Habeel Hazrat.docx");
	}
	
	
	@When("^I check whether the my resume is uploaded or not$")
	public void i_check_whether_the_my_resume_is_uploaded_or_not() throws Throwable
	
	
	{
	
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-success']")).isDisplayed());
		String actualMessage = driver.findElement(By.xpath("//div[@class='text-success']")).getAttribute("innerHTML");
		String expectedMessage = "Application submitted. Thank you for applying.";
		Assert.assertEquals(expectedMessage, actualMessage);
		Reporter.addStepLog(actualMessage);
		
	}

 
}
