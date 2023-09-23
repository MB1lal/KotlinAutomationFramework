@test @frontend @herokuapp
Feature: Form Authentication Tests

  Scenario: Valid Login
    Given I am on the form authentication page
    When I enter valid username "tomsmith" and password "SuperSecretPassword!"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Invalid Login
    Given I am on the form authentication page
    When I enter invalid username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Your username is invalid!"

  Scenario: Logout
    Given I am logged in on the form authentication page
    When I click the logout button
    Then I should be logged out and redirected to the login page
