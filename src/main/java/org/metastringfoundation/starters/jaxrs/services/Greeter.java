package org.metastringfoundation.starters.jaxrs.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {
    private String greeting = "Hello";

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
