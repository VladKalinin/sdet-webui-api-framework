package com.vvkalinin.pageobject.homepage;

import com.vvkalinin.utils.annotations.bodyclass.BodyClass;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("homePage")
@Url("/")
@Profile("us")
@BodyClass("body.page-home")
public class HomePageUs extends AbstractHomePage {


}
