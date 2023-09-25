@test @frontend @herokuapp
Feature: Checkboxes Page Tests

  Scenario: Toggle Checkboxes
    Given I am on the checkboxes page
    When I toggle the first checkbox
    Then the first checkbox should be selected
    When I toggle the second checkbox
    Then the second checkbox should be deselected
