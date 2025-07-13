Feature: Login with invalid credentials

  Scenario: Login user with incorrect email and password
    Given User is on the Home page
    When User clicks on the Signup/Login link
    And User enters an invalid email and password
    And User clicks the Login button
    Then An error message "Your email or password is incorrect!" should be displayed
