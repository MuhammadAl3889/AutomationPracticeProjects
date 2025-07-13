Feature: Product Review functionality

  Scenario: Add review to a product
    Given User is on the Product Detail page
    When User scrolls down to review section
    And User enters name, email, and review message
    And User clicks Submit
    Then A success message "Thank you for your review." should be displayed
