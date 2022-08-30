package com.example.Parking.model;

import javax.persistence.*;

@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "driver_type", nullable = false)
    DriverType driverType;
    @Column(name = "first_hour", nullable = false)
    double firstHour;
    @Column(name = "second_hour", nullable = false)
    double secondHour;
    @Column(name = "next_hour_multiplier", nullable = false)
    double nextHourMultiplier; // more than the hour before

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }

    public double getFirstHour() {
        return firstHour;
    }

    public void setFirstHour(double firstHour) {
        this.firstHour = firstHour;
    }

    public double getSecondHour() {
        return secondHour;
    }

    public void setSecondHour(double secondHour) {
        this.secondHour = secondHour;
    }

    public double getNextHourMultiplier() {
        return nextHourMultiplier;
    }

    public void setNextHourMultiplier(double nextHourMultiplier) {
        this.nextHourMultiplier = nextHourMultiplier;
    }
}
