package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"}, 
		//features = {"src/test/resources/AppFeatures/AccountsPage.feature"}, //To run only AccountsPage.feature file
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				"timeline:test-output-thread/" 
				}
			)

public class MyTestRunner {

}