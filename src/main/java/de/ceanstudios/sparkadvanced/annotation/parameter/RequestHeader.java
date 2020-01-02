package de.ceanstudios.sparkadvanced.annotation.parameter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestHeader {

    String name();

}
