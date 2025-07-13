Feature: View all products and product detail

  Scenario: View all products and navigate to product detail page
    Given User clicks on Products link
    Then All products should be visible
    When User clicks on View Product of a specific product
    Then Product detail page should be opened
    And Product name, category, price, availability, condition, and brand should be visible
