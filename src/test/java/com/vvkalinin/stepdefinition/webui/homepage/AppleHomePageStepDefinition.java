package com.vvkalinin.stepdefinition.webui.homepage;

import com.vvkalinin.pageobject.pages.homepage.HomePage;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleHomePageStepDefinition extends BaseStepDefinition {

    @Autowired
    private HomePage homePage;

    @Then("^Promotion section is( not|) displayed on Home Page$")
    public void isPromoSectionDisplayed(String negation) {
        assertThat(homePage.getPromoSection().isDisplayed())
                .withFailMessage("Promotion section is%s displayed on Home Page", negation)
                .isEqualTo(negation.isEmpty());
    }

}
