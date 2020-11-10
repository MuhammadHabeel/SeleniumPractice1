Feature: ABOUT US
The ABOUT US feature provide a thorough information about Whizport

@Smoke2
Scenario Outline: Front-end: this scenario is used automate mulitiple functionality of ABOUT US

	Given  User navigate on application
	When   User click on ABOUT US button
	And    User Scroll Veritically by '<pixels>'
	Then   User mouse hover on picture 
	

Examples:
  |pixels|
  |900   |

  
