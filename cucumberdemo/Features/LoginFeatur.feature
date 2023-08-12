Feature: Login

Scenario: Successful login with valid credentials
	
	Given user launch a chrome browser
	When user enter website url as "https://admin-demo.nopcommerce.com/login"
	And enter Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then page title should be "Dashboard / nopCommerce administration"
	When  user click on logout 
	Then page title should be "Your store. Login"
	And close the browser
	
	
	
#	Scenario Outline: Successful login with valid credentials(DDT)
#	
#	Given user launch a chrome browser
#	When user enter website url as "http://admin-demo.nopcommerce.com/login"
#	And enter Email as "<email>" and Password as "<password>"
#	And click on Login
#	Then page title should be "Dashboard / nopCommerce administration"
#	When  user click on logout 
#	Then page title should be "Your store. Login"
#	And close the browser
#	
#	Examples:
#	|email|password|
#	|admin@yourstore.com|admin|
#	|admin123@yourstore.com|admin|