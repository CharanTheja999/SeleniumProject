	package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		 features = {"src/test/java/feature"}
		,glue = {"com.stepDefination"}
		,monochrome = true
				,dryRun = false
				,tags = "@Subscribed"
				,plugin = {"pretty","html:target/TestCucumberReports/cucumber.html",
						"json:target/cucumber.json"
		}

		)
public class TestNGRunner extends AbstractTestNGCucumberTests
{


	


}
