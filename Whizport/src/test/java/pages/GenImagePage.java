package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class GenImagePage extends BasePage {
	
	
	
	
														// ################################################
														// # 											  #
														// # 				Page Objects 				  #
														// # 										      #
														// ################################################
	
			private final String userVerifyWhizportLogoAndItsTextByXpath		=    "//img[@class='logowhite']";
			private final String userCheckReturnOnInvestmentIsDisplayed			=    "(//img[@class='img-responsive center-block'])[1]";
			private final String userVerifyGuidanceImageAndReturnItsTextByXpath =    "(//img[@class='attachment-img-responsive center-block size-img-responsive center-block'])[1]";
	
	
	
	
	
														// ################################################
														// # 											  #
														// # 				Getter Methods 				  #
														// # 										      #
														// ################################################
			
			public WebElement getuserVerifyWhizportLogoAndItsTextByXpathh() 	  throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userVerifyWhizportLogoAndItsTextByXpath));}
			public WebElement getuserCheckReturnOnInvestmentIsDisplayed()   	  throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userCheckReturnOnInvestmentIsDisplayed));}
			public WebElement getuserVerifyGuidanceImageAndReturnItsTextByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userVerifyGuidanceImageAndReturnItsTextByXpath));}



}
