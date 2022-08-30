package com.example.Parking.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(){
        return "Welcome to our Home page";
    }
}
