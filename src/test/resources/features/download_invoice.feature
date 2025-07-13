Feature: Download invoice after order placement

  Scenario: Successfully download invoice
    Given User is logged in
    And User adds a product to the cart
    When User proceeds to checkout and places the order
    Then Order success message should be displayed
    When User clicks Download Invoice button
    Then Invoice file should be downloaded successfully
