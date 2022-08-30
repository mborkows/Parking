package com.example.Parking.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String plate;
    @Column(nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime start;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime stop;
    @Column(name = "driver_type")
    @Enumerated(EnumType.STRING)
    DriverType driverType;  // it can be changed to relation with RATE table
    private Boolean paid;

    public Spot() {
    }

    public Spot(int id, String plate, LocalDateTime start, LocalDateTime stop, DriverType driverType, Boolean paid) {
        this.id = id;
        this.plate = plate;
        this.start = start;
        this.stop = stop;
        this.driverType = driverType;
        this.paid = paid;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
