Feature: Login validation
  Background:
    Given User launch Page


  Scenario Outline:  login with invalid credentials
   #Given User launch Page
   When User enters "<INVALID USERNAME>" and "<INVALID PASSWORD>"
   Then error message displayed
   And Exit from page
   Examples:
     | INVALID USERNAME |INVALID PASSWORD|
    |xyz@gmail.com               |123             |


 # @sanity @smoke
  Scenario: login with valid credentials
    #Given User launch Page
    When User enters Username and Password
   Then Successful message displayed
    And Exit from page



