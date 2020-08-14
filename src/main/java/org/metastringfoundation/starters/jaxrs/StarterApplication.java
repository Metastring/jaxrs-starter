package org.metastringfoundation.starters.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// We have to have a class that extends javax.ws.rs.core.Application with the @ApplicationPath
// annotation so that we can avoid writing web.xml file.
// This class can be used to configure JAX-RS as well.
// Jersey does provide a ResourceConfig class which we may as well have used, but fret not.
// Now, our app will be available at WEBROOT/api/*
@ApplicationPath("api")
public class StarterApplication extends Application {}
