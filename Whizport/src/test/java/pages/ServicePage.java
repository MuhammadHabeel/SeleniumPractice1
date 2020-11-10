package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class ServicePage extends BasePage{

	
	
			
															// ################################################
															// # 											  #
															// # 				Page Objects				  #
															// # 										      #
															// ################################################
			
	
			private final String clickOnServiceByXpath    =      "//*[@id='menu-item-2726']/a";
			private final String clickOnFaceBookByXpath   =      "//i[@class='fab fa-facebook-f']";
			private final String faceBookTitleByXpath     =      "//i[@class='fb_logo img sp_MIYAwS5sIZZ sx_eb07a4']";
			
	
	
	
															// ################################################
															// # 											  #
															// # 				Getter methods				  #
															// # 										      #
															// ################################################
													
	
			public WebElement getclickOnServiceByXpath()    throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnServiceByXpath));}
			public WebElement getclickOnFaceBookByXpath()   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnFaceBookByXpath));}
			public WebElement getfaceBookTitleByXpath()     throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(faceBookTitleByXpath));}

	
}
