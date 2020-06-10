@sprint210
Feature: Add new Employee

  Background: 
    Given user logged in into HRMS
    And user is navigated to Add Employee Page

  Scenario: Add Employee with first and lastname
    When user enters employees "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  Scenario: Add Employee without employee id
    When user enters employees first name and last name
    And user deletes employee id
    And user clicks save button
    Then employee is added successfully

  Scenario: AddEmployee and create Login Credentials
    When user enters employees first name and last name
    And user clicks on create login checkbox
    And user enters "<username>" and "<password>"
    And user clicks save button
    Then employee is added successfully

  @inProgress
  Scenario Outline: user enters multiple outlines
    When user enters employees "<firstname>" "<middlename>" and "<lastname>"
    And user clicks save button
    Then "<firstname>" "<middlename>" and "<lastname>" added successfully

    Examples: 
      | firstname | middlename | lastname |
      | Scarlet   | scar       | Johanson |
      | Catherina | Zeta       | Johns    |
      | hugh      | H          | Jackman  |


  Scenario: user enters multiple outlines
    When user enters different credentials
      | username     | password  |
      | scarJohnason | Syntax11@ |
      | HughJack     | Syntax11@ |
