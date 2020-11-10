package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class HomePage extends BasePage {
	
	
														// ################################################
														// # 											  #
														// # 				Page Objects 				  #
														// # 										      #
														// ################################################
	
			private final String whyWeAreHereByXpath          =   "//h3[contains(text(),'Why We Are Here?')]";
			private final String hireFromTestersPoolByXpath   =   "//a[contains(text(),'Hire From Software Testers Pool')]";
			
	
										
														// ################################################
														// # 											  #
														// # 				Getter methods				  #
														// # 										      #
														// ################################################
	
			public WebElement getHireFromTestersPool() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(hireFromTestersPoolByXpath));}
			public WebElement getwhyWeAreHereByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(whyWeAreHereByXpath));}

}


