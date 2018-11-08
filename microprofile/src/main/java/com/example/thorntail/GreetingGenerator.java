package com.example.thorntail;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 11/8/18
 */
@ApplicationScoped
public class GreetingGenerator {

    @Inject
    @ConfigProperty(name = "greeting.message")
    private String message;

    public Greeting generate(String name) {
        return new Greeting(String.format(message, name));
    }
}
