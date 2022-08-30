package com.example.Parking.repository;

import com.example.Parking.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.*;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    public List<Spot> findByPlate(String plate);

    public Spot findByPlateAndStop(String plate, Date stop);

    public List<Spot> findByPlateAndPaid(String plate, Boolean paid);
}
