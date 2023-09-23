@test @frontend
Feature: Multiple Windows Tests

  Scenario: Open and Switch Between Windows
    Given I am on the multiple windows page
    When I click the "Click Here" link to open a new window
    And I switch to the new window
    Then I should perform actions in the new window
    And I should close the new window and switch back to the original window
