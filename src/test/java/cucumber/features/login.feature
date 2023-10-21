Feature: Login Page Saucedemo

  @Login
  Scenario: Failed Login
    Given Login Page Saucedemo
    When Input Username
    And Input Invalid Password
    And click login button
    Then User get error message
