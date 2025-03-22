Feature: Login functionality on SauceDemo

  As a user of SauceDemo
  I want to test the login form
  So that I can verify the error messages and successful login behavior

  Background:
    Given I navigate to the login page

  @smoke
  Scenario: UC-1 - Invalid login with empty credentials
    When I enter username "random_username" and password "random_password"
    And I clear the username field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"

  Scenario: UC-2 - Invalid login with credentials by passing Username
    When I enter username "standard_user" and password "random_password"
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"

  Scenario: UC-3 - Valid login
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should see the title "Swag Labs"

