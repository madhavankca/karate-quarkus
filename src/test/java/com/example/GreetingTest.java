package com.example;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.core.MockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class GreetingTest {

    static MockServer server;

    @BeforeAll
    static void beforeAll() {
        server = MockServer.feature("classpath:karate/mock.feature").http(8080).build();
    }

    @AfterAll
    static void afterAll() {
        server.stop();
    }

    @Karate.Test
    Karate testGreeting() {
        return Karate.run("classpath:karate/mock.feature").relativeTo(getClass());
    }
}
