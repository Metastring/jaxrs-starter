package org.metastringfoundation.starters.jaxrs.resources;

import org.metastringfoundation.starters.jaxrs.services.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("user")
public class User {

    @Inject
    UserRepository userRepository;

    @GET
    @Path("create/{name}/{email}")
    public String createUser(@PathParam("name") String name, @PathParam("email") String email) {
        userRepository.createUser(email, name);
        return "Done!";
    }
}
