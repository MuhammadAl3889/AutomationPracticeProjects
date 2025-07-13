Feature: Scroll functionality

  Scenario: Scroll down and then up using arrow button
    Given User is on the Home page
    When User scrolls down to the footer
    Then Subscription text should be visible
    When User clicks scroll-up arrow
    Then Page should scroll to top
    And "Full-Fledged practice website for Automation Engineers" text should be visible

  Scenario: Scroll up without arrow button
    Given User is on the Home page
    When User scrolls down to the footer manually
    Then Subscription text should be visible
    When User manually scrolls back to top
    Then Page top banner should be visible
