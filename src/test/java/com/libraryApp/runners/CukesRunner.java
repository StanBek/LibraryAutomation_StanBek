package com.libraryApp.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json",},
        features = "src/test/resources/features",
        glue = "com/libraryApp/steps_definitions",
        dryRun = false,
        tags = "@3",
        publish = false
)

public class CukesRunner {
}
