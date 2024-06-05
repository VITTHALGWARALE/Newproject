package com.makemytrip.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/features",
		glue = {"com/makemytrip/stepdefinitions","com/makemytrip/utils"},
		plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" },
		monochrome = true
		)
public class MyTestRunner {

}
