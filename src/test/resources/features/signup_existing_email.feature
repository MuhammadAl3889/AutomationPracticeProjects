Feature: Signup with an already registered email

  Scenario: Attempt to signup using an existing email
    Given User is on the Home page
    When User clicks on the Signup/Login link
    And User enters an already registered email and name
    And User clicks the Signup button
    Then An error message "Email Address already exist!" should be displayed
