package de.ceanstudios.sparkadvanced.mapper;

import com.google.gson.Gson;
import de.ceanstudios.sparkadvanced.response.AdvancedResponse;
import lombok.RequiredArgsConstructor;
import spark.Request;
import spark.Response;
import spark.Route;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class MethodToRouteMapper implements Route {

    private final Object object;
    private final Method method;
    private final Gson gson = new Gson();

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // TODO: 01.01.20 map the method to an result object
        final Class<?> returnType = method.getReturnType();

        if (returnType == AdvancedResponse.class) {
            final Object body = method.invoke(object);

            return gson.toJson(body);
        }

        return gson.toJson(method.getReturnType().getConstructor().newInstance());
    }
}
