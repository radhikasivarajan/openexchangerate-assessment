package org.assessment.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.assessment"},
        features = "src/test/resources/features",
        tags = "@test",
        plugin = {"pretty",
                "json:target/cucumber-reports-api/Cucumber.json",
                "junit:target/cucumber-reports-api/Cucumber.xml",
                "html:target/cucumber-reports-api/report.html"
        })
public class testrunner {
}
