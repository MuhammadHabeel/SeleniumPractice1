Feature: Images

This feature is desing for all general images of Whizport Application



@Regression01
Scenario Outline: Front-end User check functionality of all Whizport General Images, Image buttons, Image links


		Given  User navigate on application
		And    User verify existence of Whizport logo and return its text
		And    User Scroll Veritically by '<pixels>' 
		And    User check Return On Investment(ROI) existence
		And    User scroll down by '<pixels>' 
		And    User verify Guidance General Image and return its text
		And    User Verify Job Opportunity General Image and return its text
		And    User verify Career Growth General Image and return its text
		When   User click on Our Services link 
		Then   User verify Our Service page
		And    User scroll down by '<pixels>' 
		When   User click on Directed Image link 
		Then   User see Directed Page
		And    User navigate back to Our Services page
		When   User click on Contract-To-Hire Directed Image
		Then   User see Contract-To-Hire page
		
		
		
Examples:
	|pixels|
	|650   |
		  