package com.vvkalinin.pageobject.components.californiawildfires;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Profile("us")
public class CaliforniaWildFiresDonatePopUpImpl implements CaliforniaWildFiresDonatePopUp {

    private final SelenideElement popup = $("div.section-content a[href*='californiawildfires']");

    @Override
    public boolean isDisplayed() {
        return popup.isDisplayed();
    }

}
