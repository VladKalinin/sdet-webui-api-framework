package com.vvkalinin.pageobject.pages.homepage;

import com.vvkalinin.pageobject.components.homepagepromosection.HomePagePromoSection;
import com.vvkalinin.pageobject.components.topheader.HasTopHeader;
import com.vvkalinin.pageobject.components.topheader.TopHeader;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHomePage implements HomePage, HasTopHeader {

    @Autowired(required = false)
    private TopHeader topHeader;

    @Autowired
    private HomePagePromoSection promoSection;

    @Override
    public TopHeader getTopHeader() {
        return topHeader;
    }

    @Override
    public HomePagePromoSection getPromoSection() {
        return promoSection;
    }

}
