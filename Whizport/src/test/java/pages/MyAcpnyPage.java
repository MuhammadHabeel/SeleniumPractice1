package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class MyAcpnyPage extends BasePage{
	
	
	
															// ################################################
															// # 											  #
															// # 				Page Object 				  #
															// # 										      #
															// ################################################
		
			private final String userHighLightUsernameFieldByXpath         =   "//input[@id='Login']";
			private final String userSendUsernameByXpath                   =   "//input[@id='Login']";
			private final String userSendPasswordByXpath                   =   "//input[@id='Password']";
			private final String userClickOnSignInButton                   =   "//input[@id='submit']";



							
															// ################################################
															// # 											  #
															// # 				Getter Methods 				  #
															// # 										      #
															// ################################################

			public WebElement getuserHighLightUsernameFieldByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userHighLightUsernameFieldByXpath));}
			public WebElement getuserSendUsernameByXpath() 			 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userSendUsernameByXpath));}
			public WebElement getuserSendPasswordByXpath() 			 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userSendPasswordByXpath));}
			public WebElement getuserClickOnSignInButton() 			 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnSignInButton));
		
	}
	}


