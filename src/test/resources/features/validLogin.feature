Feature: Login Validation

Scenario: User should be be able to login as an Admin using valid admin credentials

Given user should navigate to URL
When user enters valid username
And user enters valid password
And user should click on login button
Then user sees welcome admin

Scenario: User should be be able to login as an ESS using valid ess credentials

Given user should navigate to URL
When user enters valid ESS username
And user enters valid ESS password
And user should click on login button
Then user sees welcome ESS



