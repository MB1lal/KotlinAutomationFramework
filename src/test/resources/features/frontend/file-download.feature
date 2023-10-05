@test @frontend @herokuapp @download
Feature: Secure File Download Tests

  Scenario: Download a Secure File
    Given I am on the file download page
    When I download the file example.json
    Then the file should be downloaded successfully
    And I should validate the content of the downloaded file
