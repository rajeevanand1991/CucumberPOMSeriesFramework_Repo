package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/parallel"}, 
		//features = {"src/test/resources/AppFeatures/AccountsPage.feature"}, //To run only AccountsPage.feature file
		glue = {"parallel"},
		//tags = "not @Skip", //This will not execute the scenarios whichever is mentioned as @skip_scenario tag in the feature file
		plugin = {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt" //This code will rerun the failed TestCase and generate text file as failedRerun.txt under target folder
				}
			)

public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();	
	}
}