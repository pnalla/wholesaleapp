Feature: View Account Lists
  Scenario: View Account List for customer
    Given CustomerId as:
      | customerId | 12345678 |
    And all services are up and running
    When View Account lists
    Then the client receives a response status 200