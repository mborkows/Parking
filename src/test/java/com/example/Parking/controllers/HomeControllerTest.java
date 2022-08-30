package com.example.Parking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class HomeControllerTest {

    @Autowired
    private HomeController homeControllerController;

    @Test
    public void testGetHome() throws Exception {
        assertEquals("Welcome to our Home page",homeControllerController.getHome());
    }

}