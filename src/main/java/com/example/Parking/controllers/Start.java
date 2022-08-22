package com.example.Parking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Start {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String returnHome(Model model){
        return "home";
    }
}
