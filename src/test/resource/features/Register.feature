Feature: Registration Functionality

# Accounts Creates with mandatory Fields

Scenario: User creates an account only with mandatory fields
Given User navigates to Register account page
When User enters details into the below fields
|firstname|bhuvan|
|lastname|koushik|
|email|bhuvankoushik@gmail.com|
|phone|1234567890|
|password|Bhuvan@28|
|confirmpassword|Bhuvan@28|
And User selects privacy policy
And clicks on continue button
Then User Accounts should get created successfully

# Accounts Created by Filling All Given Fields

Scenario: User creates an account with all fields 
Given User navigates to Register account page
When User enters details into the below fields
|firstname|vani|
|lastname|sriprasad|
|email|vanisriprasad@gmail.com|
|phone|1234512345|
|password|vanisriprasad@2313|
|confirmpassword|vanisriprasad@2313|
And User selects Yes for Newsletter
And User selects privacy policy
And clicks on continue button
Then User Accounts should get created successfully

# Duplicate AccountPage

Scenario: User creates an duplicate account with all fields 
Given User navigates to Register account page
When User enters the details into the below fields with duplicate email
|firstname|vani|
|lastname|sriprasad|
|email|vanisriprasad@gmail.com|
|phone|1234512345|
|password|vanisriprasad@2313|
|confirmpassword|vanisriprasad@2313|
And User selects Yes for Newsletter
And User selects privacy policy
And clicks on continue button
Then User should get proper warning message about duplicate email message

# Do Not Fill any details into 

Scenario: User creates an account without filling any fields 
Given User navigates to Register account page
When User dont enter any details into field
And clicks on continue button
Then User should get proper warning message for every mandatory field