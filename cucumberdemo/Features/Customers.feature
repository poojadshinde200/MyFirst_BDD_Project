Feature: Customers

Background:steps common for all scenario
Given user launch a chrome browser
	When user enter website url as "http://admin-demo.nopcommerce.com/login"
	And enter Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then User can View Dashboard

@Sanity
Scenario: Add New Customer
	 When User click on Customers Menu
 And Click on Customers Menu Item
 And Click on Add new Button
 Then User can view Add a New Customer page
 When User Enters Customres Info
 And Click on Save Button
 Then User can View Confirmation message as "The new customer has been added successfully."
 And close the browser
 
@Regression
	Scenario: Search Customer by Email

	 When User click on Customers Menu
 And Click on Customers Menu Item
	And Enter customer EMail
	When Click on search button
	Then User should found Email in the Search table
	And close the browser 
	
 	