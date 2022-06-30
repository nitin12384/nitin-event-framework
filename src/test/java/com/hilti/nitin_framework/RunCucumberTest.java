package com.hilti.nitin_framework;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}
        //, features = {"src/test/resources/behavior/main_testing.feature"}
)
public class RunCucumberTest {
}
