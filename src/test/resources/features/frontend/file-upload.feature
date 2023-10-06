@test @frontend @herokuapp
Feature: File Upload Tests

  Scenario: Upload a File
    Given I am on the file upload page
    When I select a file to upload
    Then the file should be uploaded successfully
