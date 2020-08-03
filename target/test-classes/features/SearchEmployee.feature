@sprint2
Feature: Employee Search

  Background: Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigate to empoyee list page
@smoke
  Scenario: search employee by id
    When user enters valid employee id "10085"
    And click on search button
    Then user see employee information is displayed
@regression
  Scenario: Serach employee by name
    When user enters valid employee "john Smith"
    And click on search button
    Then user see employee information is displayed
