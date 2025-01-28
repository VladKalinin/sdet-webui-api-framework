package com.vvkalinin.pageobject;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import com.vvkalinin.utils.annotations.bodyclass.BodyClassAnnotationProcessor;
import com.vvkalinin.utils.annotations.url.UrlAnnotationProcessor;
import static java.lang.String.format;

public interface Page {

    static <T extends Page> boolean isCurrentPageOpened(Class<T> pageObject) {
        return $(format("%s",
                BodyClassAnnotationProcessor.getInstance().getAnnotationValue(pageObject.getSimpleName())))
                .shouldBe(visible).exists();
    }

    default void refreshPage() {
        refresh();
    }

    default void open() {
        Selenide.open(getUrlProcessor().getClassUrlAnnotationValue());
    }

    default UrlAnnotationProcessor getUrlProcessor() {
        return new UrlAnnotationProcessor(this);
    }

}
