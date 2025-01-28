package com.vvkalinin.utils.annotations.url;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the default page path which is used with PageObject class to open desired page.
 * If path contains dynamic parameters simply use {} to indicate such. For example: @Url("/ua/{id}")
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Url {

    String value() default "";

}
