# JAX-RS Starter

## Features

* [Jersey](https://eclipse-ee4j.github.io/jersey/) - JAX-RS reference implementation
* [Weld](https://weld.cdi-spec.org/) - CDI reference implementation
* [Hibernate](https://hibernate.org/) - ORM/JPA
* [HikariCP](https://github.com/brettwooldridge/HikariCP) - Connection pooling
* [SmallRye Config](https://smallrye.io/) - MicroProfile config
* [Grizzly](https://javaee.github.io/grizzly/) - Scalable Java NIO server
* [JSON-B](https://javaee.github.io/jsonb-spec/) - for JSON responses

### Compatibility ###

Tested to work on
* Java SE 8+ - with maven
* Tomcat 8.5
* PostgreSQL 12

### Not included (yet) ###
* Unit and integration test
* [jooq](https://jooq.org)
* Hot reloading
* [OpenAPI/Swagger](https://swagger.io/docs/specification/about/)
* JWT

## Tomcat

* `mvn package -P tomcat`
* Deploy target/jaxrs-starter.war to your application server

## Running from command line

* `mvn compile exec:java`

With credentials
* `HIBERNATE_CONNECTION_USERNAME=username HIBERNATE_CONNECTION_PASSWORD=password HIBERNATE_CONNECTION_URL=jdbc:postgresql://localhost/dbname mvn compile exec:java`

## Setting up postgres

* `sudo -u postgres psql`
* `create user username with password 'password';`
* `create database dbname with owner = username;`
* `grant all privileges on database dbname to username;`
