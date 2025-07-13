Feature: Checkout after login from Cart page

  Scenario: Login before placing order from cart
    Given User adds product to cart
    When User clicks View Cart
    And User clicks Proceed To Checkout
    Then User is redirected to login page
    When User logs in with valid credentials
    Then User is redirected back to Cart page
    When User proceeds to checkout
    And User places the order
    Then Order should be placed successfully
