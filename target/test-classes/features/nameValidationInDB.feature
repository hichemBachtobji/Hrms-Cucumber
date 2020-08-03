Feature: Name Validation against DB

Scenario: Fist name validation against DB
Given user is logged in with valid admin credentials
And user navigate to empoyee list page
When user enters valid employee id "12479"
And click on search button
Then verify table is displayed 
And get first name from table
When get first name from db
Then validate first name from ui against db
