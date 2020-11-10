package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class FaqPage extends BasePage {
	
	
												// ################################################
												// # 											  #
												// # 				Page Objects 				  #
												// # 										      #
												// ################################################
		
			private final String userCLickOnFaqLinkByXpath        =   "//*[@id=\"menu-item-2549\"]/a";
			private final String userClickOnEmpFaqByXapth         =   "//*[@id=\"1595292315610-819a538a-d453\"]/div[1]/h4/a/span";
			private final String userClickOnJobSeekerFaqByXpath   =   "//*[@id=\"1595292315611-25f210dd-c250\"]/div[1]/h4/a/span";
			private final String userClickFaceBookLinkByXpath     =   "//*[@id=\"universal-soc-link-widget-2\"]/div/ul/li[1]/a/i";
			private final String faceBookTitleByXpath             =   "//i[@class='fb_logo img sp_MIYAwS5sIZZ sx_eb07a4']";
			
			
		
		
												// ################################################
												// # 											  #
												// # 				Getter methods				  #
												// # 										      #
												// ################################################
		
		public WebElement getuserCLickOnFaqLinkByXpath()      throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userCLickOnFaqLinkByXpath));}
		public WebElement getuserClickOnEmpFaqByXapth()       throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnEmpFaqByXapth));}
		public WebElement getuserClickOnJobSeekerFaqByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnJobSeekerFaqByXpath));}
		public WebElement getuserClickFaceBookLinkByXpath()   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickFaceBookLinkByXpath));}
		public WebElement getfaceBookTitleByXpath()           throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(faceBookTitleByXpath));}


}
