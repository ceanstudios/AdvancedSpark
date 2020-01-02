package de.ceanstudios.sparkadvanced.auth;

import spark.Request;
import spark.Response;

public interface AuthenticationFilter {


    void checkAccess(Request request, Response response);

}
