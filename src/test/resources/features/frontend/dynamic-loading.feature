@test @frontend @herokuapp
Feature: Dynamic Loading Tests

  Scenario: Load Hidden Element
    Given I am on the dynamic loading page
    When I click the Example 1: Element on page that is hidden link
    And I click the "Start" button
    And I should see the loaded element on the page

  Scenario: Load Newly Created Element
    Given I am on the dynamic loading page
    When I click the Example 2: Element rendered after the fact link
    And I click the "Start" button
    Then I should see the loaded element on the page
