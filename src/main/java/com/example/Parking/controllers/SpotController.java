package com.example.Parking.controllers;

import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import com.example.Parking.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("spots")
public class SpotController {

    SpotRepository spotRepository;
    SpotService spotService;

    @Autowired
    public SpotController(SpotRepository spotRepository, SpotService spotService) {
        this.spotRepository = spotRepository;
        this.spotService = spotService;
    }

    @GetMapping
    public List<Spot> getSpots(){
        return spotRepository.findAll();
    }

    @GetMapping(value = "/{plate}")
    public List<Spot> getSpots(@PathVariable String plate){
        return spotRepository.findByPlate(plate);
    }

    @GetMapping(value = "/open/{plate}")
    public Spot getOpenSpotForPlate(@PathVariable String plate){
        return spotRepository.findByPlateAndStop(plate, null);
    }


    @PostMapping(value = "/start/{plate}")
    public Spot startSpot(@PathVariable String plate){
        return spotService.startSpot(plate);
    }

    @PostMapping(value = "/stop/{plate}")
    public Spot stopSpot(@PathVariable String plate){
        Spot spot = spotRepository.findByPlateAndStop(plate, null);
        spot.setStop(LocalDateTime.now());
        return spotRepository.save(spot);
    }


}
