package org.metastringfoundation.starters.jaxrs.services;

import org.metastringfoundation.starters.jaxrs.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepository {
    @Inject
    EntityManager entityManager;

    public void createUser(String email, String name) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        entityManager.persist(newUser);
    }
}
