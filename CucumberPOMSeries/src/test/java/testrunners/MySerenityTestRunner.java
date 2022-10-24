package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		features = { "src/test/resources/parallel/LoginPage.feature" }, //To run only LoginPage.feature alone
		//features = { "src/test/resources/parallel" },// To Run complete feature files inside parallel package
		glue = { "parallel" }, 
		plugin = {"pretty" }
		)

public class MySerenityTestRunner {

}