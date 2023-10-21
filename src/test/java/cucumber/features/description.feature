Feature: Item Description Saucedemo

  @Description
  Scenario: Success visit description from item
    Given Login Page saucedemo
    When Input username
    And Input password
    And Click login button
    And Click one title from item
    Then User is in description page