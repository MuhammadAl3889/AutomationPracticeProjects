Feature: Subscription to newsletter

  Scenario: Verify subscription in home page
    Given User scrolls down to the footer on the Home page
    When User enters email in the subscription field
    And User clicks the arrow button
    Then A message "You have been successfully subscribed!" should be displayed

  Scenario: Verify subscription in Cart page
    Given User is on the Cart page
    When User scrolls down to the footer
    And User enters email in the subscription field
    And User clicks the arrow button
    Then A message "You have been successfully subscribed!" should be displayed
