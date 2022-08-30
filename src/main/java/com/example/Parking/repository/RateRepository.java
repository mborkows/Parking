package com.example.Parking.repository;

import com.example.Parking.model.DriverType;
import com.example.Parking.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    public Rate findByDriverType(DriverType driverType);
}
