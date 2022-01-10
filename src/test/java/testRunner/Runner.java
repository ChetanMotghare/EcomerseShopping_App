package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepDefinition"},
        features = "src/test/FeatureFiles/Shop.feature",
        monochrome = true,
        dryRun =false,
        tags = "@valid",
        plugin = {"pretty","html:target/cucumber-reports",
                "junit:target/cucumber-reports/Cucumber.xml"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
