package com.vvkalinin.pageobject.homepage;

import com.vvkalinin.utils.annotations.bodyclass.BodyClass;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("homePage")
@Url("/ua")
@Profile("ua")
@BodyClass("body.page-home")
public class HomePageUa extends AbstractHomePage {
}
