Feature: Home
   
   
   
   
            
  @Smoke
  Scenario Outline: Front-end request talent from whizport application
  Given User navigate on application
  And   User Scroll Veritically by '<pixels>'
  When  User Click on Hire from software testers pool button
  Then  User see Request Talent Page
  
  Examples:
  |pixels|
  |700   |
 
  
 
  
  
            
  @Smoke1
  Scenario Outline: Front-end Upload Job Description to Whizport
  Given User navigate on application
  And   User Scroll Veritically by '<pixels>'
  When  User Click on Hire from software testers pool button
  Then  User see Request Talent Page
  And   User Scroll Veritically by '<pixels>'
  And   User enter text to Job Function field
  And   User enter text to Position Hire field 
  And   User enter click on Direct Hire Dropdwon
  And   User enterZipCode
  And   User enter Text Message to Message field
  And   I Write my first name 
  And   I write my last name
  And   I wirte my work email
  And   I write my business phone number
  And   I write my company
  And   I write job title
 Then   I click on choose file to upload my resume
 And    I clik on send button
 Then   I capture message to verify 
  
  
  
  Examples:
  |pixels|
  |700   |
  
#  @Regression
#  Scenario Outline: Front-end: Contact Information
#  I write my contact information in Whizport site for QA Testers Position
#  Given User navigate on application
#  And   User Scroll Veritically by '<pixels>'
#  When  User Click on Hire from software testers pool button
#  Then  User see Request Talent Page
#  And   User Scroll Veritically by '<pixels>'
#  And   I Write my first name 
#  And   I write my last name
#  And   I wirte my work email
#  And   I write my business phone number
#  And   I write my company
#  And   I write job title
# Then   I click on choose file to upload my resume
# And    I clik on send button
#   
#   
#Examples:
#  |pixels|
#  |700   |   
#   
#   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
  