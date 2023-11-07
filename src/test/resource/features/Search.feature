Feature: Search Functionality

Scenario: User search for valid products
Given User opens the application
When User enters valid product "HP" into search box field
And User click on Search button
Then User should get valid product displayed in searech result

Scenario: User search for invalid products
Given User opens the application
When User enters invalid product "Honda" into search box field
And User click on Search button
Then User should get warning message about no product matching

Scenario: User search without any products
Given User opens the application
When User do not enter any product name into search box field
And User click on Search button
Then User should get warning message about no product matching