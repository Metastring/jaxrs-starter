package org.metastringfoundation.starters.jaxrs.resources;

import org.metastringfoundation.starters.jaxrs.entities.User;
import org.metastringfoundation.starters.jaxrs.services.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("user")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    @Path("create/{name}/{email}")
    public String createUser(@PathParam("name") String name, @PathParam("email") String email) {
        userRepository.createUser(email, name);
        return "Done!";
    }

    @GET
    @Path("list/all")
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
