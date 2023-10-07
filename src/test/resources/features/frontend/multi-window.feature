@test @frontend @herokuapp
Feature: Multiple Windows Tests

  Scenario: Open and Switch Between Windows
    Given I am on the multiple windows page
    When I click the "Click Here" link to open a new window
    When I switch to the newly opened tab
    Then Header of the page should have New Window text
    When I switch to the previous tab
    Then Header of the page should have Opening a new window text
