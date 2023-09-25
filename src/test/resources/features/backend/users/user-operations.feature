@test @backend

  Feature: Test user operations

    Scenario: User can successfully login and logout
      Given I create a user
      When User is successfully created
      Then I login using same user
      And I logout using same user

    Scenario: User can be successfully deleted
      Given I create a user
      When User is successfully created
      Then I delete the user
      And User is successfully deleted
