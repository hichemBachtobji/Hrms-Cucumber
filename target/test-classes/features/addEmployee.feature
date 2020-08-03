@sprint210 @addEmployee
Feature: Add new Employee

  Background: 
    Given user logged in into HRMS
    And user is navigated to Add Employee Page

  @smoke
  Scenario: Add Employee with first and lastname
    When user enters employees "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  @try
  Scenario: Add Employee without employee id
    When user enters employees "Brad" and "Pitt"
    And user deletes employee id
    And user clicks save button
    Then "Brad Pitt" is added successfully

  @smoke
  Scenario: AddEmployee and create Login Credentials
    When user enters employees "James1" and "Bond1"
    And user clicks on create login checkbox
    And user enters "James007" and "Syntax123@"
    And user clicks save button
    Then "James1 Bond1" is added successfully

  @regression
  Scenario Outline: user enters multiple outlines
    When user enters employees "<firstname>" "<middlename>" and "<lastname>"
    And user clicks save button
    Then "<firstname>" "<middlename>" and "<lastname>" added successfully

    Examples: 
      | firstname | middlename | lastname |
      | Scarlet   | scar       | Johanson |
      | Catherina | Zeta       | Johns    |
      | hugh      | H          | Jackman  |

  @regression
  Scenario: user enters multiple outlines
    When user enters employee details and click on save then employee is added
      | firstname | middlename | lastname |
      | hichem    | bach       | tobji    |
      | zine      | din        | zidan    |
@problem
  Scenario: user add multiple employees from excel
    When user enters employee data from excel "Employee" sheet then employee is added
