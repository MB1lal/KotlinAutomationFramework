
Feature: Dynamic Loading Tests

  Scenario: Load Hidden Element
    Given I am on the dynamic loading page
    When I click the "Example 1: Element on page that is hidden" link
    And I click the "Start" button
    Then I should wait for the element to be visible
    And I should see the loaded element on the page
