package com.vvkalinin.stepdefinition.webui.homepage;

import com.vvkalinin.pageobject.pages.homepage.HomePageUs;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleHomePageUsStepDefinitions extends BaseStepDefinition {

    @Autowired
    private HomePageUs homePageUs;

    @Then("^California wildfires popup is( not|) displayed on Home Page$")
    public void isCaliforniaWildfiresPopupIsDisplayedOnHomePage(String negation) {
        assertThat(homePageUs.getCaliforniaWildFiresDonatePopUp().isDisplayed())
                .withFailMessage("California wildfires popup is%s displayed on Home Page", negation)
                .isEqualTo(negation.isEmpty());
    }

}
