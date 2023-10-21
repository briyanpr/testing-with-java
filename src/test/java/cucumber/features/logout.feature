Feature: Logout Saucedemo

  @Logout
  Scenario: Success logout
    Given Login Page
    When Write Username
    And Write Password
    And click login
    And click menu
    And click logout
    Then User is in login page