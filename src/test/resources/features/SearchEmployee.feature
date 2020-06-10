Feature: Employee Search

  Scenario: search employee by id
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigate to empoyee list page
    When user enters valid employee id
    And click on search button
    Then user see employee information is displayed
    
    Scenario: Serach employee by name 
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigate to empoyee list page
    When user enters valid employee name and last name
    And click on search button
    Then user see employee information is displayed
