package com.example.Parking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(SpotController.class)
class SpotControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    SpotController spotController;

    @Test
    void testStartSpot() throws Exception {
        mvc.perform(post("http://localhost:8080/start/XXX111")).andExpect(status().isOk());
    }
}