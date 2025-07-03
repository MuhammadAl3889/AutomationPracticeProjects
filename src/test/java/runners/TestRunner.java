package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefs",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@Login or @Signup"
)
public class TestRunner extends AbstractTestNGCucumberTests {}
