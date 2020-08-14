# JAX-RS Starter

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
