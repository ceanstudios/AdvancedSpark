package de.ceanstudios.sparkadvanced;

import de.ceanstudios.sparkadvanced.auth.AuthenticationFilter;
import de.ceanstudios.sparkadvanced.mapper.MappingToMethodMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spark.Spark;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AdvancedSpark {

    private final String host;
    private final int port;
    private final List<AuthenticationFilter> authenticationFilters = new ArrayList<>();
    private String keystoreFile, keystorePassword, truststoreFile, truststorePassword;

    public void init() {
        Spark.ipAddress(host);
        Spark.port(port);

        if (keystoreFile != null && truststoreFile != null) {
            Spark.secure(keystoreFile, keystorePassword, truststoreFile, truststorePassword);
        }

        Spark.init();

        Runtime.getRuntime().addShutdownHook(new Thread(Spark::stop));
    }

    public void registerController(Object object) {
        MappingToMethodMapper mappingToMethodMapper = new MappingToMethodMapper(object, authenticationFilters);

        for (Method method : object.getClass().getDeclaredMethods()) {
            mappingToMethodMapper.mapToMethod(method);
        }
    }

    public void registerAuthenticationFilter (AuthenticationFilter authenticationFilter) {
        this.authenticationFilters.add(authenticationFilter);
    }


}
