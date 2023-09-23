@test @backend @pet

  Feature: Testing the pets api


    Scenario: Verifying newly added pet through Id
      Given I add the pet with id = 10001
      When I call the pet api with id
      Then The pet with id = 10001 exists


    Scenario: Verifying newly added pet through Status
      Given I add the pet with status = sold
      When I call the pet api with status
      Then The pet has status = sold


    Scenario: Verifying newly added pet can be deleted
      Given I add the pet with id = 10002
      And I call the pet deletion api with id = 10002
      When I call the pet api with id = 10002
      Then The pet with id = 10002 doesn't exist


    Scenario: Verifying pet details are correctly updated
      Given I add the pet with id = 10001
      And I update the pet name to Unicorn
      And I update the pet status to sold
      When I call the pet api with id
      Then The pet with id = 10001 exists
      And The pet has status = sold
