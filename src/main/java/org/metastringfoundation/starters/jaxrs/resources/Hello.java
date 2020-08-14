package org.metastringfoundation.starters.jaxrs.resources;

import org.metastringfoundation.starters.jaxrs.services.Greeter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

// This class will be instantiated by jersey every time there is a call to /hello/*
@Path("hello")
public class Hello {
    // We need a greeter service, but this field will be initialized in the constructor
    private final Greeter greeter;

    // Jersey can do injection into the constructor.
    // We are asking jersey to inject "Greeter".
    // Jersey will ask the CDI injection manager for an instance of "Greeter"
    @Inject
    public Hello(Greeter greeter) {
        this.greeter = greeter;
    }

    // If a GET request is made to the root path (in this case `/hello/` ),
    // jersey, after creating a new instance of this class as described above,
    // will call this simple() function and return its result to the user
    @GET
    public String simple() {
        return greeter.getGreeting();
    }

    // Technically, the following REST endpoint should not be GET because we are changing a server resource
    // But to be able to try this in the browser, we are going to make it GET.
    // When a request is made like GET /hello/set/Hola this method gets invoked
    // The method changes the greeter service to set greeting to "Hola" from the path
    // Further requests to GET /hello will now produce "Hola"
    @GET
    @Path("/set/{greeting}")
    public String changeGreeting(@PathParam("greeting") String greeting) {
        greeter.setGreeting(greeting);
        return "Changed greeting";
    }
}
