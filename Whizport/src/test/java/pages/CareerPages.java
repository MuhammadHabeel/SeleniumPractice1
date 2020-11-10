package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class CareerPages extends BasePage {
	
	
															// ################################################
															// # 											  #
															// # 				Page Objects 				  #
															// # 										      #
															// ################################################
			private final String IEnterSoftwareManagerInEditBoxByXpath        =  "/html/body/section/div[2]/form/div/div[1]/input";
			private final String IClickOnSearchLinkByXpath                    =  "btn btn-lg btn-primary search-button";
			private final String IClickOnSoftwareManagerLinkByXpath           =  "//td[text()='Software QA Manager (Multiple positions)']";
			private final String IClickOnApplyLinkByXpath                     =  "//a[@class='btn btn-lg btn-primary']";
			private final String IEnterMyFullNameByXpath                      =  "//input[@name='name']";
			private final String IEnterMyEmailAddressByXpath                  =  "//input[@name='email']";
			private final String IEnterMyPhoneNumberByXpath                   =  "//input[@name='phone']";
			private final String IClickOnUploadResumeByXpath                  =  "//input[@class='btn btn-file-upload btn-success']";
			private final String IClickOnApplyLink1ByXpath                    =  "//input[@class='btn btn-lg btn-primary']";
			private final String IVerifyTextSuccessMessageByXpath             =  "//div[@class='text-success']";
			
			
			
															// ################################################
															// # 											  #
															// # 				Getter Methods 				  #
															// # 										      #
															// ################################################	
			public WebElement getIEnterSoftwareManagerInEditBoxByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IEnterSoftwareManagerInEditBoxByXpath));}
			public WebElement getIClickOnSearchLinkByXpath()             throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IClickOnSearchLinkByXpath));}
			public WebElement getIClickOnSoftwareManagerLinkByXpath()    throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IClickOnSoftwareManagerLinkByXpath));}
			public WebElement getIClickOnApplyLinkByXpath()              throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IClickOnApplyLinkByXpath));}
			public WebElement getIEnterMyFullNameByXpath()               throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IEnterMyFullNameByXpath));}
			public WebElement getIEnterMyEmailAddressByXpath()           throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IEnterMyEmailAddressByXpath));}
			public WebElement getIEnterMyPhoneNumberByXpath()            throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IEnterMyPhoneNumberByXpath));}
			public WebElement getIClickOnUploadResumeByXpath()           throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IClickOnUploadResumeByXpath));}
			public WebElement getIClickOnApplyLink1ByXpath()             throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IClickOnApplyLink1ByXpath));}
			public WebElement getIVerifyTextSuccessMessageByXpath()      throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(IVerifyTextSuccessMessageByXpath));}
			}	


