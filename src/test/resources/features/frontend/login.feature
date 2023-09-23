@test @frontend @herokuapp
Feature: Login Page Tests

  Scenario: Valid Login
    Given I am on the login page
    When I enter valid username "your_username" and password "your_password"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Invalid Login
    Given I am on the login page
    When I enter invalid username "invalid_username" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Invalid username or password"

  Scenario: Forgot Password
    Given I am on the login page
    When I click the "Forgot Password" link
    Then I should be on the password reset page
