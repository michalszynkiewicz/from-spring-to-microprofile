package com.example.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 11/8/18
 */
@Component
public class GreetingGenerator {
    @Value("${greeting.message}")
    private String message;

    public Greeting generate(String name) {
        return new Greeting(String.format(message, name));
    }
}
