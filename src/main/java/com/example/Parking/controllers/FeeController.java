package com.example.Parking.controllers;


import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import com.example.Parking.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fee")
public class FeeController {

    SpotRepository spotRepository;
    FeeService feeService;

    @GetMapping(value = "/{plate}")
    public double checkFee(@PathVariable String plate){
        Spot spot = spotRepository.findByPlateAndPaid(plate, Boolean.FALSE).get(0);
        double fee = feeService.countFee(spot);
        return fee;
    }

    @Autowired
    public FeeController(SpotRepository spotRepository, FeeService feeService) {
        this.spotRepository = spotRepository;
        this.feeService = feeService;
    }
}
