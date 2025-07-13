Feature: Checkout process

  Scenario: Register before placing order
    Given User registers a new account
    And User adds product to cart
    When User proceeds to checkout
    Then Address details and order summary should be visible
    When User enters description and places the order
    And User enters payment details
    Then A success message "Your order has been placed successfully!" should be displayed

  Scenario: Login before placing order
    Given User logs in with valid credentials
    And User adds product to cart
    When User proceeds to checkout
    Then Address details and order summary should be visible
    When User enters description and places the order
    And User enters payment details
    Then A success message "Your order has been placed successfully!" should be displayed
