@test @backend @petStore

Feature: Testing the pets store


  Scenario: Order is successfully placed on pet store
    Given I place an order on pet store with id = 400
    When I fetch the order using id = 400
    Then The order is successfully placed

  Scenario: Order can be successfully deleted
    Given I place an order on pet store with id = 500
    When I delete the order by id = 500
    Then The order with id = 500 shouldn't exist