package com.vvkalinin.stepdefinition.webui;

import io.cucumber.java.en.When;
import com.vvkalinin.stepdefinition.BaseStepDefinition;

public class AppleHomePageStepDefinition extends BaseStepDefinition {

    @When("test check go to home page")
    public void when() {
        System.out.println("Hello World");
    }

}
