Feature: Logout functionality

  Scenario: Logout from an existing session
    Given User is already logged in
    When User clicks the Logout button
    Then User should be redirected to the Login page
