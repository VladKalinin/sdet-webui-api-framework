package com.vvkalinin.utils.annotations.bodyclass;

import com.vvkalinin.pageobject.Page;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BodyClassAnnotationProcessor implements InitializingBean {

    private static BodyClassAnnotationProcessor instance;

    @Autowired
    private PageObjectFinder pageObjectFinder;

    public static BodyClassAnnotationProcessor getInstance() {
        return instance;
    }

    public String getAnnotationValue(String pageObject) {
        Page pageObjectBean = pageObjectFinder.getPageObjectBean(pageObject);
        BodyClass urlAnnotation = pageObjectBean.getClass().getAnnotation(BodyClass.class);
        return Optional.ofNullable(urlAnnotation)
                .map(BodyClass::value)
                .orElseThrow(() -> new IllegalStateException("Page Object may not have @BodyClass annotation"));
    }

    @Override
    public void afterPropertiesSet() {
        instance = this;
    }

}
