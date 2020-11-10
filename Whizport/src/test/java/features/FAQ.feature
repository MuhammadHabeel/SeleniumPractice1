Feature: FAQ

If user has any question can post it in the FAQ 


@Smoke10
Scenario Outline: Front-end check FAQ functionality


	Given User navigate on application
	And   User click on FAQ button
	And   User Scroll Veritically by '<pixels>'
	And   User Click on Employer FAQ
	And   User Scroll to the job seeker FAQ
	When  User click on FaceBook button
	Then  User verify WhizPort FaceBook 
	
	
	
	Examples:
  |pixels|
  |200   |	
  
	

	
	

