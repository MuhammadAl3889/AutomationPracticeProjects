Feature: Recommended Items Section

  Scenario: Add recommended items to cart
    Given User scrolls to bottom of the Home page
    Then Recommended items section should be visible
    When User adds a recommended product to cart
    Then The product should be visible in cart
