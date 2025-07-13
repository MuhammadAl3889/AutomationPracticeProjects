Feature: Product Search functionality

  Scenario: Search for an existing product
    Given User is on the Products page
    When User enters product name in search field
    And User clicks the search button
    Then Search results related to the product should be visible
