package com.vvkalinin.pageobject.pages.homepage;

import com.vvkalinin.utils.annotations.bodyclass.BodyClass;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("homePage")
@Url("/ua")
@Profile("ua")
@BodyClass("body.page-home")
public class HomePageUaImpl extends AbstractHomePage {



}
