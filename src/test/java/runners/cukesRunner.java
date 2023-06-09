package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"},
		features = "src\\test\\resources\\features",
		glue = "stepDef",
		dryRun = false
		//,tags = "@tag3"
		

		)

public class cukesRunner {
	
	

}