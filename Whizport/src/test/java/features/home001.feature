Feature: home

I want to check home functionality 



@Regression
Scenario Outline: Front-end i want to verify home feature links

		Given User navigate on application
		And   User Scroll Veritically by '<pixels>'
		When  User click on linkText Hire From Software Testers Pool
		When  User click on Join Our Software Testers Pool link
		And   User Scroll Veritically by '<pixels>'
		And   User click on arrow link
		And   User click on Join Us link
		And   User Scroll Veritically by '<pixels>'
		And   User click on Facebook link
		And   User click on Twitter link
		And   User click on linked link
		Then   User verfiy above steps
		
		
	Examples:
  |pixels|
  |650   |
  
@Sanity
Scenario Outline: Front-end user verify join our software testers pool link


        Given  User navigate on application
		And    User Scroll Veritically by '<pixels>'
		When   User click on Join Our Software Testers Pool link
		Then   User verfiy above steps
 
 	Examples:
  |pixels|
  |700   |

