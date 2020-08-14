package org.metastringfoundation.starters.jaxrs.utilities;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.hibernate.cfg.Environment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HibernateManager {
    private final EntityManagerFactory entityManagerFactory;

    private final Config config = ConfigProvider.getConfig();
    private final String username = config.getOptionalValue(Environment.USER, String.class).orElse("username");
    private final String password = config.getOptionalValue(Environment.PASS, String.class).orElse("password");
    private final String connectionString = config.getOptionalValue(Environment.URL, String.class).orElse("jdbc:postgresql://localhost/database");

    public HibernateManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "org.metastringfoundation.starters.jaxrs",
                getProperties()
        );
    }

    private Map<String, String> getProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put(Environment.USER, username);
        properties.put(Environment.PASS, password);
        properties.put(Environment.URL, connectionString);
        return properties;
    }

    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Produces
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
