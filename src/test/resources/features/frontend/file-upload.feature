@test @frontend @herokuapp  @ignore
Feature: File Upload Tests

  Scenario: Upload a File
    Given I am on the file upload page
    When I select a file to upload
    And I click the "Upload" button
    Then the file should be uploaded successfully
