package TestRunner;
import org.junit.runner.RunWith;

//import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		features = ".//Features/LoginFeatur.feature",

		glue="StepDefinition",
		dryRun = false,
		monochrome = true,
		//tags = "@Sanity",//scenarios under @sanity tag will be executed
		//plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		//plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}
		//plugin = {"pretty ","junit:target/cucumber-reports/reports_xml.xml"}
				//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
//		plugin = { "pretty", 
//				"json:target/cucumber-reports/cucumber.json",
//				"html:target/cucumber-reports/cucumberreport.html",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/reports_html.html"}
	//plugin= {
              // "pretty","html:target/cucumber-reports/reports_html.html",
              // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Run {
//	this class should be empty

}    
