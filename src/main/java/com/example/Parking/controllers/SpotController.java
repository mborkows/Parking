package com.example.Parking.controllers;

import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
public class SpotController {

    SpotRepository spotRepository;

    @Autowired
    public SpotController(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @GetMapping(value = "/spots")
    public List<Spot> getSpots(){
        return spotRepository.findAll();
    }

    @GetMapping(value = "/spots/{plate}")
    public List<Spot> getSpots(@PathVariable String plate){
        return spotRepository.findByPlate(plate);
    }

    @GetMapping(value = "/spots/open/{plate}")
    public List<Spot> getOpenSpotForPlate(@PathVariable String plate){
        return spotRepository.findByPlateAndStop(plate, null);
    }


}
