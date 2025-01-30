package com.vvkalinin.stepdefinition;

import com.vvkalinin.utils.annotations.bodyclass.PageObjectFinder;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.WebDriverRunner.url;
import static com.vvkalinin.pageobject.Page.isCurrentPageOpened;
import static com.vvkalinin.pageobject.Page.waitForPageToLoad;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseStepDefinition {

    @Autowired
    protected PageObjectFinder pageObjectFinder;

    protected void openPage(String page) {
        pageObjectFinder.getPageObjectBean(page).open();
    }

    protected void verifyCurrentPage(String page) {
        waitForPageToLoad();
        assertThat(isCurrentPageOpened(page))
                .as("Browser is not on " + page + ". Current page is " + url())
                .isTrue();
    }

}
