package de.ceanstudios.sparkadvanced.mapper;

import de.ceanstudios.sparkadvanced.annotation.mapping.*;
import de.ceanstudios.sparkadvanced.auth.AuthenticationFilter;
import spark.Spark;

import java.lang.reflect.Method;
import java.util.List;

import static spark.Spark.*;

public class MappingToMethodMapper {

    private final Object object;
    private final MethodParameterMapper methodParameterMapper;
    private final List<AuthenticationFilter> authenticationFilters;

    public MappingToMethodMapper(Object object, List<AuthenticationFilter> authenticationFilters) {
        this.object = object;
        this.authenticationFilters = authenticationFilters;
        this.methodParameterMapper = new MethodParameterMapper();
    }

    public void mapToMethod(final Method method) {
        if (method.isAnnotationPresent(ConnectMapping.class)) {
            final ConnectMapping annotation = method.getAnnotation(ConnectMapping.class);

            connect(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            final DeleteMapping annotation = method.getAnnotation(DeleteMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            delete(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(GetMapping.class)) {
            final GetMapping annotation = method.getAnnotation(GetMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            get(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(HeadMapping.class)) {
            final HeadMapping annotation = method.getAnnotation(HeadMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            head(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(OptionsMapping.class)) {
            final OptionsMapping annotation = method.getAnnotation(OptionsMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            options(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PatchMapping.class)) {
            final PatchMapping annotation = method.getAnnotation(PatchMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            patch(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            final PostMapping annotation = method.getAnnotation(PostMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            post(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            final PutMapping annotation = method.getAnnotation(PutMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            put(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        } else if (method.isAnnotationPresent(TraceMapping.class)) {
            final TraceMapping annotation = method.getAnnotation(TraceMapping.class);

            if (annotation.secure()) {
                Spark.before(annotation.uri(), (request, response) -> this.authenticationFilters.forEach(authenticationFilter -> authenticationFilter.checkAccess(request, response)));
            }

            trace(annotation.uri(), new MethodToRouteMapper(methodParameterMapper, object, method));
        }
    }

}
