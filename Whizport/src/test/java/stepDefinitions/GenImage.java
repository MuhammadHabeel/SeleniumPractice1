package stepDefinitions;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import utility.BasePage;

public class GenImage extends BasePage {
	
	
	@Given("^User verify existence of Whizport logo and return its text$")
	public void user_verify_existence_of_Whizport_logo_and_return_its_text() throws Throwable 
	
	{//ask Ustad Ahad: but could not find code in wrapper to
	System.out.println(driver.findElement(By.xpath("//img[@class='logowhite']")).isDisplayed());
	System.out.println(driver.findElement(By.xpath("//img[@class='logowhite']")).getAttribute("class"));
	//System.out.println(driver.findElement(By.xpath("//img[@class='logowhite']")).getText());//getText() method will return image text
	}
	
	
	@Given("^User check Return On Investment\\(ROI\\) existence$")
	public void user_check_Return_On_Investment_ROI_existence() throws Throwable 
	
	{
		System.out.println(driver.findElement(By.xpath("(//img[@class='img-responsive center-block'])[1]")).isDisplayed());
	}

	
	
	@Given("^User verify Guidance General Image and return its text$")
	public void user_verify_Guidance_General_Image_and_return_its_text() throws Throwable 
	
	{
	   System.out.println(driver.findElement(By.xpath("(//img[@class='attachment-img-responsive center-block size-img-responsive center-block'])[1]")).getText());
	}

}
