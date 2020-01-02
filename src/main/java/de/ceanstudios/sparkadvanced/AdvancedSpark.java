package de.ceanstudios.sparkadvanced;

import de.ceanstudios.sparkadvanced.mapper.MappingToMethodMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spark.Spark;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AdvancedSpark {

    private final String host;
    private final int port;
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
        MappingToMethodMapper mappingToMethodMapper = new MappingToMethodMapper(object);

        for (Method method : object.getClass().getDeclaredMethods()) {
            mappingToMethodMapper.mapToMethod(method);
        }
    }


}
