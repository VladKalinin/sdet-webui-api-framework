package com.vvkalinin.pageobject.components.topheader;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Profile("desktop")
public class TopHeaderImpl implements TopHeader {

    private final SelenideElement topHeader = $("#globalnav");

    @Override
    public boolean isDisplayed() {
        return topHeader.isDisplayed();
    }

    @Override
    public void clickOnTab(String tab) {
        getTopHeaderTab(tab).shouldBe(visible).click();
    }

    private SelenideElement getTopHeaderTab(String tab) {
        return topHeader.$(format("ul li a.globalnav-link-%s", tab.toLowerCase()));
    }

}
