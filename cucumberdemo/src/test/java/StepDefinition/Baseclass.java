package StepDefinition;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomer;
import PageObject.Loginpage;
import PageObject.SearchCustomerByEmail;

import org.apache.logging.log4j.*;

import org.apache.logging.log4j.*;

public class Baseclass {
	public WebDriver driver;
	public Loginpage lp;
	public AddNewCustomer an;
	public SearchCustomerByEmail se;
	
	
	
	
	public String generateuniqemailid()
	{
		
		return RandomStringUtils.randomAlphabetic(5);
	}

}
