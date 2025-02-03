package com.vvkalinin.pageobject.components.welcomevideo;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class WelcomeVideoImpl implements WelcomeVideo {

    private final SelenideElement welcomeVideo = $("video.welcome-video-video");

    @Override
    public boolean isDisplayed() {
        sleep(1000);
        return welcomeVideo.isDisplayed();
    }

}
