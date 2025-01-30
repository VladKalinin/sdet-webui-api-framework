package com.vvkalinin.stepdefinition.webui.topheader;

import com.vvkalinin.pageobject.components.topheader.HasTopHeader;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TopHeaderStepDefinitions extends BaseStepDefinition {

    @When("^click on ([\\w\\s]+) tab on ([\\w\\s]+)$")
    public void clickOnTab(String tab, String page) {
        getPageWithTopHeader(page).getTopHeader().clickOnTab(tab);
    }

    @Then("^Top header is( not|) displayed on ([\\w\\s]+)$")
    public void isTopHeaderDisplayed(String negation, String page) {
        assertThat(getPageWithTopHeader(page).getTopHeader().isDisplayed())
                .withFailMessage("Top header is%s displayed on %s", negation, page)
                .isEqualTo(negation.isEmpty());
    }

    private HasTopHeader getPageWithTopHeader(final String page) {
        return pageObjectFinder.getBeanOfTypeByClassName(page, HasTopHeader.class);
    }

}
