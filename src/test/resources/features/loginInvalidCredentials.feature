@sprint200
Feature: invlaid credentials

  Scenario: Login with invalid credentials
    When I enter invalid "<UserName>" and "<Password>" and see "<ErrorMessage>"

      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid credentials |
      | Hello    | Syntax123! | Invalid credentials |
