Feature: Transaction Saucedemo

  @Transaction
  Scenario: Success Transaction
    Given Login page saucedemo
    When input username
    And input password
    And Click Login Button
    And Click one item to add to cart
    And Click cart
    And CLick checkout button
    And input name
    And input last name
    And input postal code
    And Click continue button
    And Click finish button
    Then Checkout complete page appear
