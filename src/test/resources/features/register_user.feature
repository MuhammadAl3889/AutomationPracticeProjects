Feature: Register User

  Scenario: Register user with valid details
    Given User is on the Home page
    When User clicks on the Signup/Login link
    And User enters a new name and unique email address
    And User clicks on the Signup button
    And User fills in account information with personal and address details
    And User clicks the Create Account button
    Then A confirmation message "ACCOUNT CREATED!" should be visible
    When User clicks the Continue button
    Then User should be logged in and see "Logged in as <username>"
    When User clicks Delete Account
    Then A confirmation message "ACCOUNT DELETED!" should be visible
