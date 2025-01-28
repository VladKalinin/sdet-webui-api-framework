package com.vvkalinin.utils.annotations.bodyclass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the body class of a Page Object which is used to identify whether the page is opened or not.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BodyClass {

    String value();

}
