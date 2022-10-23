package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/parallel/ContactUs.feature"}, 
		//features = {"src/test/resources/AppFeatures/AccountsPage.feature"}, //To run only AccountsPage.feature file
		glue = {"parallel"},
		plugin = {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				"timeline:test-output-thread/" 
				}
			)

public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();	
	}
}