@test @frontend @herokuapp
Feature: Notification Messages Tests

  Scenario: Click Notification Messages
    Given I am on the notification messages page
    When I generate a new notification
    Then I should see one of the correct notification messages
    When I generate a new notification
    Then I should see one of the correct notification messages