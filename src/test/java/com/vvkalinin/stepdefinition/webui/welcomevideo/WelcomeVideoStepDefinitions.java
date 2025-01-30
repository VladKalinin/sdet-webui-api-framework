package com.vvkalinin.stepdefinition.webui.welcomevideo;

import com.vvkalinin.pageobject.components.welcomevideo.HasWelcomeVideo;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeVideoStepDefinitions extends BaseStepDefinition {

    @Then("^welcome video is( not|) displayed on ([\\w\\s]+)$")
    public void isWelcomeVideoDisplayed(String negation, String page) {
        assertThat(getPageWithWelcomeVideo(page).getWelcomeVideo().isDisplayed())
                .withFailMessage("Welcome video is%s displayed on %s", negation, page)
                .isEqualTo(negation.isEmpty());
    }

    private HasWelcomeVideo getPageWithWelcomeVideo(final String page) {
        return pageObjectFinder.getBeanOfTypeByClassName(page, HasWelcomeVideo.class);
    }

}
