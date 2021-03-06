package nl.fontys.jea.kwetter;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import rest.KweetResource;
import rest.UserResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saya
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application
{
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // Register my custom provider.
        classes.add(JAXRSConfiguration.class);
        //classes.add(KweetResource.class);
        classes.add(UserResource.class);
        classes.add(KweetResource.class);
        return classes;
    }
}
