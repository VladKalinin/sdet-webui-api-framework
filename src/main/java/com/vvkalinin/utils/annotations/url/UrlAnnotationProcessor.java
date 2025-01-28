package com.vvkalinin.utils.annotations.url;

import com.vvkalinin.pageobject.Page;

import java.util.Optional;

public class UrlAnnotationProcessor {

    private final Class<? extends Page> pageObjectClass;

    public UrlAnnotationProcessor(Page pageObject) {
        this.pageObjectClass = pageObject.getClass();
    }

    public String getClassUrlAnnotationValue() {
        Url urlAnnotation = getUrl();
        return Optional.ofNullable(urlAnnotation)
                .map(Url::value)
                .orElseThrow(() -> new IllegalStateException("Class may not have @Url annotation"));
    }

    private Url getUrl() {
        return pageObjectClass.getAnnotation(Url.class);
    }

}