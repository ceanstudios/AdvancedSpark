package de.ceanstudios.sparkadvanced.annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PatchMapping {

    String uri();

    boolean secure() default false;

}
