package com.vvkalinin.pageobject.components.homepagepromosection;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class HomePagePromoSectionImpl implements HomePagePromoSection {

    private final SelenideElement promoSection = $("section[data-module-template='promos']");

    @Override
    public boolean isDisplayed() {
        return promoSection.isDisplayed();
    }

}
