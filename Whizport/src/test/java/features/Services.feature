Feature: Services
This feature used to provide information about Direct Hire and Contract to Hire


@Smoke5
Scenario Outline: Front-end User automate all the OUR SERVICES functionality
	Given User navigate on application
	When  User click on our services
	And   User Scroll Veritically by '<pixels>'
	And   User click on facebook link
	Then  User verify Whizport on facebook site
	
	
	Examples:
	|pixels|
	|11000  |