package org.metastringfoundation.starters.jaxrs.services;

import org.metastringfoundation.starters.jaxrs.entities.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class UserRepository {
    @Inject
    EntityManager entityManager;

    public void createUser(String email, String name) {
        entityManager.getTransaction().begin();
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();
    }

    public List<User> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
