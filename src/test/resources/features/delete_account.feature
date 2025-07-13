Feature: Delete account after placing an order

  Scenario: Delete user account after order completion
    Given User registers a new account
    And User adds product to cart
    When User places the order with valid payment details
    Then Order confirmation should be shown
    When User deletes the account
    Then A message "ACCOUNT DELETED!" should be visible
