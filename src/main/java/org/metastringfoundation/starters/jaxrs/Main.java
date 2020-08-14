package org.metastringfoundation.starters.jaxrs;


import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;

import java.net.URI;

// This class is helpful when we want to run the app in Java SE
// (that is what you might do when deploying to cloud)
public class Main {
    public static HttpServer startServer(String baseUri) {
        // create a resource config that scans for JAX-RS resources and providers
        ResourceConfig rc = new ResourceConfig().packages("org.metastringfoundation.starters.jaxrs");

        System.out.println("Classes being loaded:");
        rc.getClasses().forEach(c -> System.out.println("* " + c.getName()));

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at baseUri
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
    }

    public static void main(String[] args) {
        Weld weld = new Weld();
        weld.initialize();
        Config config = ConfigProvider.getConfig();
        String port = config.getOptionalValue("jaxrs.port", String.class).orElse("8081");
        String context = config.getOptionalValue("jaxrs.root", String.class).orElse("jaxrs-starter");

        final String baseUri = "http://localhost:" + port + "/" + context + "/api/";
        final HttpServer server = startServer(baseUri);
        System.out.printf("Jersey app started at %s%n", baseUri);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        Runtime.getRuntime().addShutdownHook(new Thread(weld::shutdown));
    }
}
