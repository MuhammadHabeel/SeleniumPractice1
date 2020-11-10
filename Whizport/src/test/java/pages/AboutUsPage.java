package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class AboutUsPage extends BasePage{
	
	
												// ################################################
												// # 											  #
												// # 				Page Objects 				  #
												// # 										      #
												// ################################################
	
		private final String clickOnAboutUsByXpath           =    "//*[@id=\"menu-item-2548\"]/a";
		private final String mouseHoverOnOurByXpath          =    "//*[@id=\"page-top\"]/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div[2]/div/p";
	
	
	
	
	
												// ################################################
												// # 											  #
												// # 				Getter Methods 				  #
												// # 										      #
												// ################################################
	
		public WebElement getclickOnAboutUsByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnAboutUsByXpath));}
		public WebElement getmouseHoverOnOurByXpath()throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(mouseHoverOnOurByXpath));}
	

}
