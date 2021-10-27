package blackbox.com.anz.wholesaleapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html:build/reports/cucumber/html",
                "json:build/reports/cucumber/json",
                "usage:build/reports/cucumber/usage.json",
                "json:build/reports/cucumber/junit.xml"
        },
        tags = {"not @Ignore"}
)
public class CucumberTestRunner {
}
