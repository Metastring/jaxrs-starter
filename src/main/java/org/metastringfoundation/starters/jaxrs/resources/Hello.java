package org.metastringfoundation.starters.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class Hello {
    @GET
    public String simple() {
        return "Hello";
    }
}
