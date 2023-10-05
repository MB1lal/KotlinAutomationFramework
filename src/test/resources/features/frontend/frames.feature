@test @frontend @herokuapp
Feature: Frames Tests

  Scenario: Nested Frames
    Given I am on the frames page
    When I navigate to Nested Frames page
    Then Top Left frame has LEFT text
    And Top Middle frame has MIDDLE text
    * Bottom frame has BOTTOM text
    * Top Right frame has RIGHT text

   Scenario: Write Text In An iFrame
     Given I am on the frames page
     When I navigate to iFrame page
     Then I write Kotlin Automation Framework in iframe
     And iframe has the text Kotlin Automation Framework