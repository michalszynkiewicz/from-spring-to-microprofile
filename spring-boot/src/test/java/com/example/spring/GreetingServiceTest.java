/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.spring;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingServiceTest {

    private static final String BASE_URI = "http://localhost:%d";
    private static final String GREETING_PATH = "api/greeting";

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testGreetingEndpoint() {
        given()
                .baseUri(String.format(BASE_URI, port))
                .get(GREETING_PATH)
                .then()
                .statusCode(200)
                .body("content", is("Hello from Spring Boot, World!"));
    }

    @Test
    public void testGreetingEndpointWithNameParameter() {
        given()
                .baseUri(String.format(BASE_URI, port))
                .param("name", "John")
                .get(GREETING_PATH)
                .then()
                .statusCode(200)
                .body("content", is("Hello from Spring Boot, John!"));
    }

}
