package de.ceanstudios.sparkadvanced.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OptionsMapping {

    String uri();

    boolean secure() default false;

}
