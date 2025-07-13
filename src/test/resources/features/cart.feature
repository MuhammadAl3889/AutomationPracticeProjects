Feature: Shopping Cart functionality

  Scenario: Add product to cart and verify in cart page
    Given User is on the Products page
    When User adds a product to the cart
    And User clicks View Cart
    Then The product should be visible in the cart

  Scenario: Verify product quantity in cart
    Given User is on the Product Detail page
    When User sets product quantity to 4
    And User adds product to cart
    And User clicks View Cart
    Then The cart should display quantity as 4

  Scenario: Verify cart after login
    Given User adds a product to cart
    And User clicks View Cart
    When User logs in with valid credentials
    Then The cart should retain previously added product
