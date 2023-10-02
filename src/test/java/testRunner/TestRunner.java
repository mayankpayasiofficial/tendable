package testRunner;
import org.junit.AfterClass;
import static org.BaseClass.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", // Path to your feature file(s)
		glue = "stepDefinitions"
		,plugin = {"pretty", "html:target/cucumber-reports/cucumber.xml",
				"html:target/cucumber-reports/cucumber.json",
		"html:target/cucumber-html-reports.html"}
		,tags = "@test"
		)
public class TestRunner {


	@AfterClass
	public static void tearDown() {
		// Close the WebDriver instance after all scenarios
		if (driver != null) {
			driver.quit();
		}
	}
}
