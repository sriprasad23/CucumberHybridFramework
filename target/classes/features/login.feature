Feature: Login functionality

# to intigrate data driven testing used 1st scenario 
# instead of Sceario use Scenario Outline and use Examples | username |password | as parameters
# use <username> <password>arrow brackets to parametarize user name and password 
 
Scenario Outline: Login with valid Credentials

Given User navigates to login page
When User enterd valid email address <username> into email field
And User enterd valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in message
Examples: 
|username           |password|
|vanicap1@gmail.com |12345|
|vanicap2@gmail.com |12345|
|vanicap3@gmail.com |12345|
|vanicap4@gmail.com |12345|


Scenario: Login with invalid credentials

Given User navigates to login page
When User enterd invalid email address into email field
And User enterd invalid password "Dhruvanth" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password credentials
Given User navigates to login page
When User enterd valid email address "dhruva@gmail.com" into email field
And User enterd invalid password "Dhruvanth" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password credentials
Given User navigates to login page
When User enterd invalid email address into email field
And User enterd valid password "Dhruva" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User do not enterd email address into email field
And User do not enterd password into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch
