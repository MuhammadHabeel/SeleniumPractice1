package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class WhizportLinksPage extends BasePage{
	
	
	
	
															// ################################################
															// # 											  #
															// # 				Page Objects 				  #
															// # 										      #
															// ################################################
	
		private final String collectAllWhizportLinksBytagName           =  "a";
		private final String collectAllWhizportImagesBytagName			=  "img";
	
		
		
		
															// ################################################
															// # 											  #
															// # 				Page Objects 				  #
															// # 										      #
															// ################################################
		public WebElement getcollectAllWhizportLinksBytagName()  throws Exception {return wrapper.findApplicationObjectDynamically(By.tagName(collectAllWhizportLinksBytagName));}
		public WebElement getcollectAllWhizportImagesBytagName() throws Exception {return wrapper.findApplicationObjectDynamically(By.tagName(collectAllWhizportImagesBytagName));}


}
