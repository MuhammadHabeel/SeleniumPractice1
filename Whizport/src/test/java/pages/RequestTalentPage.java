package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class RequestTalentPage extends BasePage{
	
	
	
													// ################################################
													// # 											  #
													// # 				Page Object 				  #
													// # 										      #
													// ################################################
											
											
	private final String requestTalentTitleByXpath             ="//h1[contains(text(),'Request Talent')]";
	private final String jobFucntionByXpath                    ="//input[@name='JobFunction']";
	private final String positionHiringForFieldBycssSelector   ="#wpcf7-f2714-p2711-o1 > form > div:nth-child(3) > span > input";
	private final String clickOnDirectHireDropDownByXpath      ="//select[@name='PositionType']";
	private final String enterZipCodeByXpath                   ="//*[@id=\"wpcf7-f2714-p2711-o1\"]/form/div[5]/span/input";
	private final String enterTextByXpath                      ="//textarea[@name='your-message']";
	private final String firstNameByXpath                      ="//input[@name='FirstName']";
	private final String lastNameByXpath                       ="//input[@name='LastName']";
	private final String sendEmailToTheFieldByxpath            ="//input[@name='WorkEmail']";
	private final String sendNumberToPhoneFieldByXpath         ="//input[@name='tel']";
	private final String sendNameToCompanyFieldByXpath         ="//input[@name='Company']";
	private final String sendJobTitleToJobTitleFieldByXpath    ="//input[@name='JobTitle']";
	private final String clickChooseFileByXpath                ="//input[@name='file-99']";
	private final String clickOnSendButtonByXpath              ="//input[@class='wpcf7-form-control wpcf7-submit']";
	private final String clickOnContractToHireByXpath          ="//*[@id=\"wpcf7-f2714-p2711-o1\"]/form/div[4]/span/select/option[2]";
	//private final String captureMessageToVerifyByXpath       	="//*[@id=\"wpcf7-f2714-p2711-o1\"]/form/div[14]";
	private final String captureMessageToVerifyByXpath         ="//div[@class='wpcf7-response-output']";
	
	
	
	
	
	
	
	
	
													// ################################################
													// # 											  #
													// # 				Getter methods				  #
													// # 										      #
													// ################################################
											
	public WebElement getRequestTalentTitleByXpath()           throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(requestTalentTitleByXpath));}
	public WebElement getclickChooseFileByXpath() 			   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickChooseFileByXpath));}
	public WebElement getjobFucntionByXpath()  				   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(jobFucntionByXpath));}
	public WebElement getpositionHiringForFieldBycssSelector() throws Exception {return wrapper.findApplicationObjectDynamically(By.cssSelector(positionHiringForFieldBycssSelector));}
	public WebElement getclickOnDirectHireDropDownByXpath()    throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnDirectHireDropDownByXpath));}
	public WebElement getenterZipCodeByXpath() 				   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(enterZipCodeByXpath));}
	public WebElement getenterTextByXpath() 				   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(enterTextByXpath));}
	public WebElement getfirstNameByXpath() 				   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(firstNameByXpath));}
	public WebElement getlastNameByXpathByXpath() 			   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(lastNameByXpath));}
	public WebElement getsendEmailToTheFieldByxpath() 		   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(sendEmailToTheFieldByxpath));}
	public WebElement getsendNumberToPhoneFieldByXpath() 	   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(sendNumberToPhoneFieldByXpath));}
	public WebElement getsendNameToCompanyFieldByXpath() 	   throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(sendNameToCompanyFieldByXpath));}
	public WebElement getsendJobTitleToJobTitleFieldByXpath()  throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(sendJobTitleToJobTitleFieldByXpath));}
	public WebElement getclickOnSendButtonByXpath()            throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnSendButtonByXpath));}
	public WebElement getclickOnContractToHireByXpath()        throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(clickOnContractToHireByXpath));}
	//public WebElement getcaptureMessageToVerifyByXpath()     throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(captureMessageToVerifyByXpath));}
	public WebElement getcaptureMessageToVerifyByXpath()       throws Exception {return wrapper.findApplicationObjectDynamically(By.xpath(captureMessageToVerifyByXpath));}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
