@dbhw
Feature: Last Name Validation in db

Scenario: validate Last name in db
Given user is logged in with valid admin credentials
And user navigate to empoyee list page
When user enters valid employee id "12479"
And click on search button
And verify tavle is displayed
Then get last name from table
And get last name from db
And validate last name in UI against DB  
