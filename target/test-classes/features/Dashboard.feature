#author:bachtobji.hichem@gmail.com

Feature: Dashboard
@dash
Scenario: Dashboard menu view for admin
When user is logged in with valid admin credentials
Then user see dashboard menu is displayed
|Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory| 