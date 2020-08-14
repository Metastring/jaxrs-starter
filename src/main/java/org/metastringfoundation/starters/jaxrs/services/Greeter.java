package org.metastringfoundation.starters.jaxrs.services;

import javax.enterprise.context.ApplicationScoped;

// We are telling the CDI injection manager to recognize/register the Greeter class
// We are also telling the CDI manager to only create one instance of Greeter for the entire application
// by setting @ApplicationScoped (as opposed to @RequestScoped)
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
