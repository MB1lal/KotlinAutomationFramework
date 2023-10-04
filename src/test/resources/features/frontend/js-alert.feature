@test @frontend @herokuapp
Feature: JavaScript Alerts Tests

  Scenario: Handle JavaScript Alerts
    Given I am on the JavaScript alerts page
    When I click the "Click for JS Alert" button of alert
    Then I should see a JavaScript alert
    And I interact as accept with the alert
    When I click the "Click for JS Confirm" button of alert
    Then I should see a JavaScript confirmation dialog
    And I interact as dismiss with the confirmation
    When I click the "Click for JS Prompt" button of alert
    Then I should see a JavaScript prompt dialog
    And I enter "Test Input" in the prompt
    And I interact as accept with the prompt
