package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class hooks {

	WebDriver driver;

	@Before
	public void setup() {
		
		Properties prop = configReader.initializeProperties();
		driver = Driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		 
	}

	@After
	public void tearDown(Scenario scenario) {
		
		// To Take screen shots before closing the browser this code will take screen shots and attached in cucumber reports
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		
		driver.quit();
	}

}
