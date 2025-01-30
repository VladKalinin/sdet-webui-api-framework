package com.vvkalinin.pageobject.pages.homepage;

import com.vvkalinin.pageobject.components.californiawildfires.CaliforniaWildFiresDonatePopUp;
import com.vvkalinin.utils.annotations.bodyclass.BodyClass;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("homePage")
@Url("/")
@Profile("us")
@BodyClass("body.page-home")
public class HomePageUsImpl extends AbstractHomePage implements HomePageUs {

    @Autowired
    private CaliforniaWildFiresDonatePopUp californiaWildFiresDonatePopUp;

    @Override
    public CaliforniaWildFiresDonatePopUp getCaliforniaWildFiresDonatePopUp() {
        return californiaWildFiresDonatePopUp;
    }

}
