@test @frontend @herokuapp
Feature: Hovers Tests

  Scenario: Hover Over User Avatars
    Given I am on the hovers page
    When I hover over the first user avatar
    Then I should see name: user1 for the first user
    When I hover over the second user avatar
    Then I should see name: user2 for the second user
    When I hover over the third user avatar
    Then I should see name: user3 for the third user
