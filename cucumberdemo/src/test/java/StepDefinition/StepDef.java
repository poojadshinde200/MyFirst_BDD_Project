package StepDefinition;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.*;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.mortbay.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import PageObject.AddNewCustomer;
import PageObject.Loginpage;
import PageObject.SearchCustomerByEmail;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import java.io.*;
import java.util.*;

public class StepDef extends Baseclass {
	// creating object
	public static Logger Log;

	// reading property file
	public ReadConfig readconfig;

	@Given("user launch a chrome browser")
	public void user_launch_a_chrome_browser() {
		// initialization of object
		//Log = LogManager.getLogger("StepDef");
		
//		readconfig = new ReadConfig();
//	String browser = readconfig.getBrowser();
		String browser="msedge";
		System.out.println("poojashinde");
//		
		switch (browser.toLowerCase()) {
		case "chrome":
			//ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver(chromeOptions);
			 ChromeOptions chromeOptions = new ChromeOptions();
			    chromeOptions.addArguments("--start-maximized");
			    chromeOptions.addArguments("--remote-allow-origins=*");
				 driver = new ChromeDriver(chromeOptions);
//			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			WebDriverManager.chromedriver().setup();
//			WebDriver driver = new ChromeDriver(chromeOptions);
//			
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
	//	EdgeOptions options1 = new EdgeOptions();
		//	options1.addArguments("--remote-allow-origins=*");
			//driver = new EdgeDriver();
			
			
			EdgeOptions Options = new EdgeOptions();
			Options.addArguments("--start-maximized");
			Options.addArguments("--remote-allow-origins=*");
				 driver = new EdgeDriver(Options);
				 break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options3 = new FirefoxOptions();
		options3.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options3);
			break;

		default:
			driver = null;
			break;

		}

		// ****************without switch************************
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//driver = new ChromeDriver();

		lp = new Loginpage(driver);
		an = new AddNewCustomer(driver);
		se = new SearchCustomerByEmail(driver);
		// *****************log4j*****************
	//	Log.info("lauch a browser");

	}

//	@BeforeStep
//	public void beforestep() {
//		System.out.println("pooja");
//	}
//
//	@AfterStep
//	public void afterstep() {
//		System.out.println("shinde");
//	}

	@When("user enter website url as {string}")
	public void user_enter_website_url_as(String url) {
		//System.out.println("hello url");
		driver.get(url);
		//driver.quit();
		

		// *****************log4j*****************
		//Log.info("lauch a website url");

	}

	@When("enter Email as {string} and Password as {string}")
	public void enter_email_as_and_password_as(String emailid, String pass) {
		lp.enterEmail(emailid);
		lp.enterpassword(pass);
		// *****************log4j*****************
		//Log.info("user has enter username and password");

	}


	
	
	@When("click on Login")
	public void click_on_login() {
		lp.clickonLogin();
		// *****************log4j*****************
	//	Log.info("click on login");

	}

	// ****************************LOGIN **********************************

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("user click on logout")
	public void user_click_on_logout() {
		lp.clickonLogout();
		// *****************log4j*****************
	//	Log.info("click on logout button");

	}

	@Then("close the browser")

	public void close_the_browser() {
		driver.close();
		// *****************log4j*****************
	//	Log.info("close the browser");

	}

	// @After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed..");
		if (sc.isFailed() == true) {
			// Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\Administrator\\eclipse-workspace\\cucumberdemo\\ScreenShort\\failedscreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// *****************log4j*****************
		//Log.info("screenshot has captured");

		driver.quit();
	}

	//***************//extend report//********************
	@AfterStep  
	public void addScreenshot(Scenario scenario) 
	{
		if(scenario.isFailed()==true)
		{
		final byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png",scenario.getName());
		}
			
		}

	// **********************ADD NEW CUSTOMERS***********************

	@Then("User can View Dashboard")
	public void user_can_view_dashboard() {

		String actualTitle = an.getpagetitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// *****************log4j*****************
		//Log.info("user verify dashboard page");

	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {
		an.clickOnCustomersMenu();
		// *****************log4j*****************
		//Log.info("user has click On CustomersMenu");

	}

	@When("Click on Customers Menu Item")
	public void click_on_customers_menu_item() {
		an.clickOnCustomersMenuItem();
		// *****************log4j*****************
		//Log.info("user has click On CustomersMenuItem");

	}

	@When("Click on Add new Button")
	public void click_on_add_new_button() {
		an.clickOnAddnew();
		// *****************log4j*****************
	//	Log.info("user has click Add new Button");

	}

	@Then("User can view Add a New Customer page")
	public void user_can_view_add_a_new_customer_page() {
		String actualTitle = an.getpagetitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// *****************log4j*****************
	//	Log.info("verify the page Add new customer");

	}

	@When("User Enters Customres Info")
	public void user_enters_customres_info() {

		an.enterEmail(generateuniqemailid() + "@gmail.com");
		an.enterpassword("kuku123");
		an.enterFirstName("kumar");
		an.enterLastName("shinde");
		an.enterGender("male");
		an.enterDob("3/14/2023");
		an.enterCompanyName("mahindra");
		// an.entertax("true");
		// an.newsletter("Test store 2");
		// an.enterCustomerRoles("Guests");
		// an.enterManagerOfVendor("Vendor1");
		an.enterActive("true");
		// an.enterAdminContent("welcome");

		// *****************log4j*****************
	//	Log.info("user enter info ");

	}

	@When("Click on Save Button")
	public void click_on_save_button() {
		an.clickOnSave();
		// *****************log4j*****************
		//Log.info("click on Button");

	}

	@Then("User can View Confirmation message as {string}")
	public void user_can_view_confirmation_message_as(String expectedTitle) {
		String actualTitle = an.getconfirmationmsg();

		if (actualTitle.contains(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// *****************log4j*****************
		//Log.info("user verify confirmation msg");

	}

	// *************Search Customer by Email********************

	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		se.enterEmailid("james_pan@nopCommerce.com");
		// *****************log4j*****************
		//Log.info("user has customer EMail");

	}

	@When("Click on search button")
	public void click_on_search_button() {
		se.clickonserchbtn();
		// *****************log4j*****************
	//	Log.info("user has click on search button");

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {

		// String actualemail=se.searchbyEmail(null)
		String expectedemail = "james_pan@nopCommerce.com";
		if (se.searchbyEmail(expectedemail) == true)
		// if(se.searchbyEmail()==true)
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// *****************log4j*****************
	//	Log.info("verify email found in table or not");

	}

}
