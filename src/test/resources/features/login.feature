Feature: Login validation
  #Background:
    #Given User is on Login Page


  #Scenario Outline:  login with invalid credentials
   #Given User is on Login Page
   # When User enters "<INVALID USERNAME>" and "<INVALID PASSWORD>"
   # Then error message displayed
   # And Exit from page
   # Examples:
   #   | INVALID USERNAME |INVALID PASSWORD|
   # |xyz               |123             |


 # @sanity @smoke
  Scenario: login with valid credentials
    Given User is on Login Page
    #When User enters "graceanto0099@gmail.com" and "India@2019"
   # Then Successful login message displayed
    #And Exit from page



