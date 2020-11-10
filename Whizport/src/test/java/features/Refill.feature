Feature: Refill Medication

Patient request Refill Medication through online portal

	@Smoke01
	Scenario Outline: Front-end, User check Refill Medication functionality
	
	Given  User navigate on application
	And   User highlight username field
	And   User write '<username>'
	And   User highlight username field
	And   User write '<password>'
	And   User highlight username field
	When  User clicks on Sign in button
	And   User Scroll Veritically by '<pixels>'
	And   User click Refill Medication
	And   User click Request Refills button
	And   User scroll down by '<pixels>'
	And   User click on checkbox
	When  User click on Next button
	Then  User see different page
	
	
	
	
	Examples:
	|username|password  |pixels|
	|"Hazrat"|Hazrat@123|200   |
	