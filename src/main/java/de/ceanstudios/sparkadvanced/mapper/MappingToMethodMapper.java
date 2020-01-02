package de.ceanstudios.sparkadvanced.mapper;

import de.ceanstudios.sparkadvanced.annotation.mapping.*;

import java.lang.reflect.Method;

import static spark.Spark.*;

public class MappingToMethodMapper {

    private final Object object;
    private final MethodParameterMapper methodParameterMapper;

    public MappingToMethodMapper(Object object) {
        this.object = object;
        this.methodParameterMapper = new MethodParameterMapper();
    }

    public void mapToMethod(final Method method) {
        if (method.isAnnotationPresent(ConnectMapping.class)) {
            final ConnectMapping annotation = method.getAnnotation(ConnectMapping.class);

            connect(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            final DeleteMapping annotation = method.getAnnotation(DeleteMapping.class);

            delete(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(GetMapping.class)) {
            final GetMapping annotation = method.getAnnotation(GetMapping.class);

            get(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(HeadMapping.class)) {
            final HeadMapping annotation = method.getAnnotation(HeadMapping.class);

            head(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(OptionsMapping.class)) {
            final OptionsMapping annotation = method.getAnnotation(OptionsMapping.class);

            options(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PatchMapping.class)) {
            final PatchMapping annotation = method.getAnnotation(PatchMapping.class);

            patch(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            final PostMapping annotation = method.getAnnotation(PostMapping.class);

            post(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            final PutMapping annotation = method.getAnnotation(PutMapping.class);

            put(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(TraceMapping.class)) {
            final TraceMapping annotation = method.getAnnotation(TraceMapping.class);

            trace(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        }
    }

}
