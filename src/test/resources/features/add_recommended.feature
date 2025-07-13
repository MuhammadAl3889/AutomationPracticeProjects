Feature: Add recommended products to cart

  Scenario: Add item from Recommended Items section
    Given User scrolls to bottom of the Home page
    When Recommended items section is visible
    And User adds a recommended product to the cart
    And User clicks View Cart
    Then The recommended product should be visible in the cart
