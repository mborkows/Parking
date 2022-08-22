package com.example.Parking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class StartTest {

    @Autowired
    private Start startController;

    @Test
    public void shouldPassIfStringMatches() throws Exception {
        assertThat(startController).isNotNull();
    }

}