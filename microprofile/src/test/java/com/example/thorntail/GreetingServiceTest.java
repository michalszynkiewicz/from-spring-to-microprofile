/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.thorntail;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * @author Heiko Braun
 */
@RunWith(Arquillian.class)
@DefaultDeployment
public class GreetingServiceTest {

    private static final String BASE_URI = "http://localhost:8080";
    private static final String GREETING_PATH = "api/greeting";

    @Test
    @RunAsClient
    public void testGreetingEndpoint() {
        given()
                .baseUri(BASE_URI)
                .get(GREETING_PATH)
                .then()
                .statusCode(200)
                .body("content", is("Hello from Thorntail, World!"));
    }

    @Test
    @RunAsClient
    public void testGreetingEndpointWithNameParameter() {
        given()
                .baseUri(BASE_URI)
                .param("name", "John")
                .get(GREETING_PATH)
                .then()
                .statusCode(200)
                .body("content", is("Hello from Thorntail, John!"));
    }

}
