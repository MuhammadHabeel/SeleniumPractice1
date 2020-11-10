package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import utility.BasePage;

public class RequestTalent extends BasePage{
	
	
	@Then("^User Scroll Veritically by '<pixels>'$")
	public void user_Scroll_Veritically_by_pixels(int arg1) throws Throwable {
		wrapper.scrollingInThePageByPixels(arg1);
	}
	

	
	@Then("^User enter text to Job Function field$")
	public void user_enter_text_to_Job_Function_field() throws Throwable {
	   wrapper.enterTextField(talent.getjobFucntionByXpath(), "Software Automation");
	   Reporter.addStepLog("Software Automation");
	}
	
	
	
	@Then("^User enter text to Position Hire field$")
	public void user_enter_text_to_Position_Hire_field() throws Throwable {
		 wrapper.enterTextField(talent.getpositionHiringForFieldBycssSelector(), "QA Tester");
	    
	}
	
	
	

	@Then("^User enter click on Direct Hire Dropdwon$")
	public void user_enter_click_on_Direct_Hire_Dropdwon() throws Throwable
	
	{
		wrapper.clickWebElement(talent.getclickOnContractToHireByXpath());
	}
	
	
	
	@Then("^User enterZipCode$")
	public void user_enterZipCode() throws Throwable
	
	{
	   wrapper.enterTextField(talent.getenterZipCodeByXpath(), "11580");
	}
	

	
	@Then("^User enter Text Message to Message field$")
	public void user_enter_Text_Message_to_Message_field() throws Throwable 
	
	{
	    wrapper.enterTextField(talent.getenterTextByXpath(), "I am uploading my information in Whizport site for Software Automation Position");
	    Reporter.addStepLog("I am uploading my information in Whizport site for Software Automation Position");
	}
	
	
	@Then("^I Write my first name$")
	public void i_Write_my_first_name() throws Throwable 
	
	{
	    wrapper.enterTextField(talent.getfirstNameByXpath(), "fnu");
	}
	
	

	@Then("^I write my last name$")
	public void i_write_my_last_name() throws Throwable 
	
	{
	    wrapper.enterTextField(talent.getlastNameByXpathByXpath(), "qais");

	}

	
	
	@Then("^I wirte my work email$")
	public void i_wirte_my_work_email() throws Throwable 
	
	{
	    wrapper.enterTextField(talent.getsendEmailToTheFieldByxpath(), "qais480@gmail.com");
	}

	
	
	@Then("^I write my business phone number$")
	public void i_write_my_business_phone_number() throws Throwable 
	
	{
	   wrapper.enterTextField(talent.getsendNumberToPhoneFieldByXpath(), "6468069973");
	}

	
	
	@Then("^I write my company$")
	public void i_write_my_company() throws Throwable 
	
	{
	    wrapper.enterTextField(talent.getsendNameToCompanyFieldByXpath(), "Rally Health");
	}
	
	

	@Then("^I write job title$")
	public void i_write_job_title() throws Throwable 
	
	{
	   wrapper.enterTextField(talent.getsendJobTitleToJobTitleFieldByXpath(), "Lead IT");
	}
	
	

	@Then("^I click on choose file to upload my resume$")
	public void i_click_on_choose_file_to_upload_my_resume() throws Throwable 
	
	{
		wrapper.scrollingInThePageByPixels(100);
		//wrapper.fileUpload(talent.getclickChooseFileByXpath(), "C:\\Users\\MOHAMMAD KAMAL(QAIS)\\Desktop\\Interview Questions2.docx");
		driver.get("file:///C:/Users/MOHAMMAD%20KAMAL(QAIS)/Desktop/fileuploadd.html");
		driver.findElement(By.name("resumeupload")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\MOHAMMAD KAMAL(QAIS)\\Desktop\\AutoIt1234\\FileUpload1234.exe");
		wrapper.getEmbedScreenShot();
	}

	
	
	@Then("^I clik on send button$")
	public void i_clik_on_send_button() throws Throwable 
	
	{
		wrapper.scrollingInThePageByPixels(300);
	    wrapper.clickWebElement(talent.getclickOnSendButtonByXpath());
	    Thread.sleep(5000);
	    wrapper.getEmbedScreenShot();
	    
	}
	
	
	@Then("^I capture message to verify$")
	public void i_capture_message_to_verify() throws Throwable 
	{

	//String actualMessage = driver.findElement(By.xpath("//div[@class='wpcf7-response-output']")).getText();
		
		
		
		//second way
		//Assert.assertTrue(actualMessage.contains("Thank you for your message! Our recruitment team will contact you soon"));
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='wpcf7-response-output']")));
		
		//third way
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wpcf7-response-output']")).isDisplayed());
				String actualMessage = driver.findElement(By.xpath("//div[@class='wpcf7-response-output']")).getAttribute("innerHTML");
				String expectedMessage = "Thank you for your message! Our recruitment team will contact you soon!";
				Assert.assertEquals(expectedMessage, actualMessage);
				Reporter.addStepLog(actualMessage);
				
	}
	

	
		
	
	
	
	
	

}
