package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0) //To read the config.properties
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory(); //creating DriverFactory object to call init_driver() method
		driver = driverFactory.init_driver(browserName); //will launch that particular browser and assign it to driver to avoid null pointer exception atlast while quit the browser
	}

	@After(order = 0) //in @After cucumber annotation, order = 0 ===> will execute last
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1) //in @After cucumber annotation, order = 1 ===> will execute first
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); //we are using BYTES to work in CI/CD tool like jenkins/Bamboo instead of using FILE
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}