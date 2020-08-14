package org.metastringfoundation.starters.jaxrs.resources;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

// In this class we will explore MicroProfile Config which allows configuration be injected
// from sources like environment variable
@Path("config")
public class Config {
    // It gels with the idea of CDI
    @Inject
    // The property that we are looking for is "jaxrs.port".
    // If none of the default sources specify this value, the defaultValue is used
    // In our case, we are setting it in META-INF/microprofile-config.properties to 8082
    @ConfigProperty(name = "jaxrs.port", defaultValue = "8081")
    private String port;

    @GET
    public String check() {
        return "works";
    }

    @GET
    @Path("port")
    public String getPort() {
        return port;
    }
}
