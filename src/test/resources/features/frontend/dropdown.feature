@test @frontend @herokuapp
Feature: Dropdown Page Tests

  Scenario: Select Option from Dropdown
    Given I am on the dropdown page
    When I select option Option 2 from the dropdown
    Then the selected option should be Option 2