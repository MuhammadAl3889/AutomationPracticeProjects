@Login @Signup
Feature: Login and Signup functionality

  Scenario: Signup with new user
    Given User is on homepage
    When User navigates to Signup Login page
    And User enters name "TestUser" and email "testuser@example.com" for signup
    And User clicks Signup button
    Then User should be redirected to account information page

  Scenario: Login with invalid credentials
    Given User is on homepage
    When User navigates to Signup Login page
    And User enters login email "invalid@example.com" and password "wrongpass"
    And User clicks Login button
    Then User should see login error
