@test @frontend @herokuapp
Feature: Frames Tests

  Scenario: Switch Between Frames
    Given I am on the frames page
    When I switch to the first frame
    And I interact with elements in the first frame
    Then I should switch back to the main content
    When I switch to the second frame
    And I interact with elements in the second frame
    Then I should switch back to the main content
