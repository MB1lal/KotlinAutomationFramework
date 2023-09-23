@test @frontend @herokuapp
Feature: JavaScript Alerts Tests

  Scenario: Handle JavaScript Alerts
    Given I am on the JavaScript alerts page
    When I click the "Click for JS Alert" button
    Then I should see a JavaScript alert
    And I accept the alert
    When I click the "Click for JS Confirm" button
    Then I should see a JavaScript confirmation dialog
    And I dismiss the confirmation
    When I click the "Click for JS Prompt" button
    Then I should see a JavaScript prompt dialog
    And I enter "Test Input" in the prompt
    And I accept the prompt
