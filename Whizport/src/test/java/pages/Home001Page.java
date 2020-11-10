package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class Home001Page extends BasePage {
	
	
	
							
													// ################################################
													// # 											  #
													// # 				Page Objects 				  #
													// # 										      #
													// ################################################
	
			private final String userClickOnHireFromSoftwareTestersPoolByXpath        =   "(//a[contains(text(),'Hire From Software Testers Pool')])[1]";
			private final String userClickOnJoinOurSoftwareTesterPoolByPartialLinkText=   "Join Our Software";
			private final String userClickOnArrowLinkByXpath                          =   "//span[(@class='icon-next')]";
			private final String userClickOnJoinUsLinkByXpath                         =   "//a[@class='btn btn-info']";
			private final String userClickOnFaceBookLinkByXpath                       =   "//i[(@class='fab fa-facebook-f')]";
			private final String userClickOnTwitterLinkByXpath                        =   "//i[(@class='fab fa-twitter')]";
			private final String userClickOnLinkedByXpath                             =   "//i[@class='fab fa-linkedin-in']";


	
	
	
													// ################################################
													// # 											  #
													// # 				Getter Methods 				  #
													// # 										      #
													// ################################################
	
	
			public WebElement getuserClickOnHireFromSoftwareTestersPoolByXpath()         throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnHireFromSoftwareTestersPoolByXpath));}
			public WebElement getuserClickOnJoinOurSoftwareTesterPoolByPartialLinkText() throws Exception {return wrapper.findApplicationObjectDynamically(By.partialLinkText(userClickOnJoinOurSoftwareTesterPoolByPartialLinkText));}
			public WebElement getuserClickOnArrowLinkByXpath() 							 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnArrowLinkByXpath));}
			public WebElement getuserClickOnJoinUsLinkByXpath() 						 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnJoinUsLinkByXpath));}
			public WebElement getuserClickOnFaceBookLinByXpath() 						 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnFaceBookLinkByXpath));}
			public WebElement getuserClickOnTwitterLinkByXpath()   						 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnTwitterLinkByXpath));}
			public WebElement getuserClickOnLinkedByXpath() 							 throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(userClickOnLinkedByXpath));}




}
