@test @frontend @herokuapp
Feature: Secure File Download Tests

  Scenario: Download a Secure File
    Given I am on the secure file download page
    When I click the "Download" link
    Then the file should be downloaded successfully
    And I should validate the content of the downloaded file
