package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class WhizportMenu extends BasePage {
	
	
	
	
	
			 
																// ################################################
																// # 											  #
																// # 				Page Objects				  #
																// # 										      #
																// ################################################
																	
		
			private final String WhizporthomeByXpath         =   "(//a[contains(text(),'Home')])[1]";
			private final String WhizportaboutUsByXpath      =   "(//a[contains(text(),'About Us')])[1]";
			private final String WhizportourServicesByXpath  =   "(//a[contains(text(),'Our Services')])[1]";
			private final String WhizportfaqByXpath          =   "(//a[contains(text(),'FAQ')])[1]";
			private final String WhizportcontactUsByXpath    =   "(//a[contains(text(),'Contact Us')])[1]";
			private final String WhizportCareerByXpath		 =   "(//a[contains(text(),'Career')])[1]";
			

																// ################################################
																// # 											  #
																// # 				Page Objects				  #
																// # 										      #
																// ################################################
																	

			public WebElement getWhizporthomeByXpath()        throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizporthomeByXpath));}
			public WebElement getWhizportaboutUsByXpath()     throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizportaboutUsByXpath));}
			public WebElement getWhizportourServicesByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizportourServicesByXpath));}
			public WebElement getWhizportfaqByXpath()         throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizportfaqByXpath));}
			public WebElement getWhizportcontactUsByXpath()   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizportcontactUsByXpath));}
			public WebElement getWhizportCareerByXpath()      throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(WhizportCareerByXpath));}

	}



