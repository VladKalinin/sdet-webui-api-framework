package com.vvkalinin.pageobject.pages.watchpage;

import com.vvkalinin.pageobject.components.topheader.HasTopHeader;
import com.vvkalinin.pageobject.components.topheader.TopHeader;
import com.vvkalinin.pageobject.components.welcomevideo.HasWelcomeVideo;
import com.vvkalinin.pageobject.components.welcomevideo.WelcomeVideo;
import com.vvkalinin.utils.annotations.bodyclass.BodyClass;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("watchPage")
@Url("/watch")
@BodyClass("body.page-watch")
public class WatchPageImpl implements WatchPage, HasTopHeader, HasWelcomeVideo {

    @Autowired(required = false)
    private TopHeader topHeader;

    @Autowired
    private WelcomeVideo welcomeVideo;

    @Override
    public TopHeader getTopHeader() {
        return topHeader;
    }

    @Override
    public WelcomeVideo getWelcomeVideo() {
        return welcomeVideo;
    }

}
