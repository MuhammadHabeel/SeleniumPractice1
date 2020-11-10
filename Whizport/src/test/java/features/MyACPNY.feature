Feature: Login

I want to login to MyACPNY Account 

@Smoke0
Scenario Outline: Front-end, User want to checks MyACPNY login functianlity 


	Given  User navigate on application
	And   User highlight username field
	And   User write '<username>'
	And   User write '<password>'
	When  User clicks on Sign in button
	Then  User land to Advantage Care Physician page
	
	
	
	Examples:
	|username|password  |
	|"Hazrat"|Hazrat@123|
	
	

