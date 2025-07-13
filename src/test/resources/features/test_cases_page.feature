Feature: View Test Cases page

  Scenario: Navigate to and verify the Test Cases page
    Given User is on the Home page
    When User clicks on the Test Cases link
    Then The user should be navigated to the Test Cases page
    And Test Cases content should be visible
