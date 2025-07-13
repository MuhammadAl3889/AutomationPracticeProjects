Feature: Browse products by category

  Scenario: View products under Women > Dress category
    Given User clicks on Women category
    When User clicks on Dress subcategory
    Then Products related to Women - Dress should be displayed
