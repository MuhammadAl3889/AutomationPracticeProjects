Feature: Login with valid credentials

  Scenario: Login user with correct email and password
    Given User is on the Home page
    When User clicks on the Signup/Login link
    And User enters a valid email and password
    And User clicks the Login button
    Then User should be logged in and see "Logged in as <username>"
    When User clicks Delete Account
    Then A confirmation message "ACCOUNT DELETED!" should be visible
