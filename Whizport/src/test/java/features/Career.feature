Feature: Career
I recieved new release from developer and want to test its functionality




@Regression123
Scenario Outline: Front-end this scenaro used to add upload resume in Whizport

	Given I navigate to the Application
	And   I click on Career Menu Link
	And   I enter to the edit box '<Software QA Manager>'  
	And   I click on Search link
	And   User Scroll Veritically by '<pixels>'
	And   I click Software QA Manager (Multiple Options)
	And   User Scroll Veritically by '<pixels>'
	And   I click on Apply image link
	And   I enter in the edit box '<My Full Name>'
	And   I enter my email address '<My Email Address>'
	And   I enter my phone number '<My Phone Number>'
	And   I click upload my resume
	When  I check whether the my resume is uploaded or not
	And   I click on Apply image link

	#Then  I verify Text Success confirmation message
	
	
	
	
	
Examples:
|Software QA Manager||My Full Name            ||My Email Address      ||pixels|
|"Software Manager" ||"Muhammad Habeel Hazrat"||"te.fnuqais@gmail.com"||700   |

	
	
	
	
	
	