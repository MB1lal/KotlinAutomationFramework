@test @frontend @herokuapp
Feature: JavaScript Alerts Tests

  Scenario: Verify working of JS Alerts
    Given I am on the JavaScript alerts page
    When I click the JS Alert button of alert
    Then I interact as OK with the alert
    And Result says You successfully clicked an alert

  Scenario: Verify working of JS Confirm
    Given I am on the JavaScript alerts page
    When I click the JS Confirm button of alert
    And I interact as CANCEL with the confirmation
    * Result says You clicked: Cancel

  Scenario: Verify working of JS prompt
    Given I am on the JavaScript alerts page
    When I click the JS Prompt button of alert
    And I enter Test Input in the prompt
    * I interact as OK with the prompt
    * Result says You entered: Test Input
