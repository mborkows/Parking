package com.example.Parking.service;

import com.example.Parking.handlerException.EntityAlreadyExistsException;
import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;

@Service
public class SpotService {

    SpotRepository spotRepository;

    @Autowired
    public SpotService(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public Spot startSpot(String plate) {
        Spot spot = spotRepository.findByPlateAndStop(plate, null);
        if (spot != null) {
            throw new EntityAlreadyExistsException(String.format("Spot for %s is already open", plate));
        }
        Spot spotNew = new Spot();
        spotNew.setPlate(plate);
        spotNew.setStart(LocalDateTime.now());
        return spotRepository.save(spotNew);

    }
}
