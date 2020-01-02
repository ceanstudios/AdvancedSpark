package de.ceanstudios.sparkadvanced.mapper;

import com.google.gson.Gson;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestBody;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestHeader;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestParam;
import lombok.RequiredArgsConstructor;
import spark.Request;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class MethodParameterMapper {

    private final Gson gson = new Gson();

    public Object[] mapParametersForMethod(final Method method, final Request request) {
        Object[] objects = new Object[method.getParameterTypes().length];

        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        int index = 0;
        for (Class<?> methodParameterType : method.getParameterTypes()) {

            for (Annotation annotation : method.getParameterAnnotations()[index]) {
                if (annotation.annotationType() == RequestHeader.class) {
                    String headerName = ((RequestHeader) annotation).name();

                    objects[index] = stringToSimpleObjectMapper.map(methodParameterType, request.headers(headerName));
                } else if (annotation.annotationType() == RequestParam.class) {
                    String requestParameterName = ((RequestParam) annotation).name();

                    objects[index] = stringToSimpleObjectMapper.map(methodParameterType, request.params(requestParameterName));
                } else if (annotation.annotationType() == RequestBody.class) {
                    final Object body = gson.fromJson(request.body(), methodParameterType);

                    objects[index] = body;
                }
            }

            index++;
        }

        return objects;
    }

}
