package de.ceanstudios.sparkadvanced.mapper;

import de.ceanstudios.sparkadvanced.annotation.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class MappingToMethodMapper {

    private final Object object;

    public void mapToMethod(final Method method) {
        if (method.isAnnotationPresent(ConnectMapping.class)) {

        } else if (method.isAnnotationPresent(DeleteMapping.class)) {

        } else if (method.isAnnotationPresent(GetMapping.class)) {

        } else if (method.isAnnotationPresent(HeadMapping.class)) {

        } else if (method.isAnnotationPresent(OptionsMapping.class)) {

        } else if (method.isAnnotationPresent(PatchMapping.class)) {

        } else if (method.isAnnotationPresent(PostMapping.class)) {

        } else if (method.isAnnotationPresent(PutMapping.class)) {

        } else if (method.isAnnotationPresent(TraceMapping.class)) {

        }
    }

}
