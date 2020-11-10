package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class ContactUsPage extends BasePage{
	
	
	
															// ################################################
															// # 											  #
															// # 				Page Objects 				  #
															// # 										      #
															// ################################################
			
			private final String userMoveMouseToContactUsButtonByXpath     =   "//li[@id='menu-item-2727']";
			private final String userClickOnReqTalentByXpath               =  "//*[@id=\"menu-item-2728\"]/a";




							
															// ################################################
															// # 											  #
															// # 				Getter Methods 				  #
															// # 										      #
															// ################################################

			public WebElement getuserClickOnReqTalentByXpath()           throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnReqTalentByXpath));}
			public WebElement getuserMoveMouseToContactUsButtonByXpath() throws Exception {return wrapper.findApplicationObjectDynamicallyByVisibilityOfElement(By.xpath(userMoveMouseToContactUsButtonByXpath));
}
}
