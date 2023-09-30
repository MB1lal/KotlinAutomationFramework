@test @ignore
Feature: Notification Messages Tests

  Scenario: Click Notification Messages
    Given I am on the notification messages page
    When I click the "Click here" link multiple times
    Then I should see different notification messages
