Feature: Cart retains items after login

  Scenario: Verify cart content after login
    Given User adds product to cart without login
    When User logs in with valid credentials
    Then The previously added products should remain in the cart
