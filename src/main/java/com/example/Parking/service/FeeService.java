package com.example.Parking.service;

import com.example.Parking.model.Rate;
import com.example.Parking.model.Spot;
import com.example.Parking.repository.RateRepository;
import com.example.Parking.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class FeeService {

    SpotRepository spotRepository;
    RateRepository rateRepository;


    public double countFee(Spot spot){
        Rate rate = rateRepository.findByDriverType(spot.getDriverType());
        long timeInMinutes = countTimeInMinutes(spot);
        double fee = countFee(rate,timeInMinutes);
        return fee;
    }

    private double countFee(Rate rate, long timeInMinutes) {
        double fee = 0;
        fee = rate.getFirstHour();
        if(timeInMinutes <=60){
            return fee;
        }
        fee = rate.getFirstHour()+rate.getSecondHour();
        if(timeInMinutes <= 120){
            return fee;
        }
        timeInMinutes -= 120;
        double nextfee = rate.getSecondHour()*rate.getNextHourMultiplier();
        while(timeInMinutes>0){
            fee += nextfee;
            nextfee *= rate.getNextHourMultiplier();
            timeInMinutes-=60;
        }

        return fee;
    }

    private long countTimeInMinutes(Spot spot){
        LocalDateTime stopTime = spot.getStop() == null ? LocalDateTime.now() : spot.getStop();
        LocalDateTime startTime = spot.getStart();
        Duration duration = Duration.between(startTime, stopTime);
        return duration.toMinutes();
    }

    public FeeService(){};

    @Autowired
    public FeeService(SpotRepository spotRepository, RateRepository rateRepository){
        this.spotRepository = spotRepository;
        this.rateRepository = rateRepository;
    }
}
