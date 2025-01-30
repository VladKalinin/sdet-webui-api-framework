package com.vvkalinin.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowserStepDefinitions extends BaseStepDefinition {

    @When("^(?:opens|has opened) ([\\w\\s]+ Page)$")
    public void navigateToPage(String page) {
        openPage(page);
    }

    @Then("^browser is on ([\\w\\s]+)$")
    public void verifyBrowserOnPage(String page) {
        verifyCurrentPage(page);
    }

}
