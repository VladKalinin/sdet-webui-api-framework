package com.vvkalinin.stepdefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.vvkalinin",
        features = {"src/test/resources/features"},
        monochrome = true,
        stepNotifications = true
)
public class CucumberRunner {

}
