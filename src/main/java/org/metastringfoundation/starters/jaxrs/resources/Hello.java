package org.metastringfoundation.starters.jaxrs.resources;

import org.metastringfoundation.starters.jaxrs.services.Greeter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("hello")
public class Hello {
    private final Greeter greeter;

    @Inject
    public Hello(Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    public String simple() {
        return greeter.getGreeting();
    }

    @GET
    @Path("/set/{greeting}")
    public String changeGreeting(@PathParam("greeting") String greeting) {
        greeter.setGreeting(greeting);
        return "Changed greeting";
    }
}
