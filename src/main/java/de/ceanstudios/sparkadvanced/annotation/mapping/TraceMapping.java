package de.ceanstudios.sparkadvanced.annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TraceMapping {

    String uri();

    boolean secure() default false;

}
