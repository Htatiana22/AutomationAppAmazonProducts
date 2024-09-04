Feature: Add products to cart
  As a user
  Want to enter the Amazon application
  To select multiple products


@Scenario:
  Scenario: Select products and add to the shopping cart
    Given User enters the Amazon application
    When User searches for the products and adds them to the shopping cart
    Then User validates the name of the selected products

