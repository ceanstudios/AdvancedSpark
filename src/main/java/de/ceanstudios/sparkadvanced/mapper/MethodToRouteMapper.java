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

    private final MethodParameterMapper methodParameterMapper;
    private final Object object;
    private final Method method;
    private final Gson gson = new Gson();

    @Override
    public Object handle(Request request, Response response) throws Exception {
        final Class<?> returnType = method.getReturnType();

        response.type("application/json");

        if (returnType == AdvancedResponse.class) {
            final Object[] parameters = methodParameterMapper.mapParametersForMethod(method, request);
            final AdvancedResponse advancedResponse = (AdvancedResponse) method.invoke(object, parameters);

            if (advancedResponse.getBody() != null) {
                return gson.toJson(advancedResponse.getBody());
            }

            return gson.toJson(advancedResponse);
        }

        return gson.toJson(method.getReturnType().getConstructor().newInstance());
    }
}
