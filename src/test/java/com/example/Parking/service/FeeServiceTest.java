package com.example.Parking.service;

import com.example.Parking.model.DriverType;
import com.example.Parking.model.Spot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeeServiceTest {

    LocalDate localDate = LocalDate.now();
    @Autowired
    FeeService feeService;

    @Test
    void countFee() {
        Spot spot1 = new Spot(1, "TEST-111", LocalDateTime.of(localDate,LocalTime.of(12, 0, 0)), LocalDateTime.of(localDate, LocalTime.of(15, 0, 0)), DriverType.REGULAR, Boolean.FALSE);
        assertEquals(6, feeService.countFee(spot1));

        Spot spot2 = new Spot(1, "TEST-111", LocalDateTime.of(localDate,LocalTime.of(12, 0, 0)), LocalDateTime.of(localDate, LocalTime.of(15, 1, 0)), DriverType.REGULAR, Boolean.FALSE);
        assertNotEquals(6, feeService.countFee(spot2));

        Spot spot3 = new Spot(1, "TEST-111", LocalDateTime.of(localDate,LocalTime.of(12, 0, 0)), LocalDateTime.of(localDate, LocalTime.of(14, 0, 0)), DriverType.DISABLED, Boolean.FALSE);
        assertEquals(2, feeService.countFee(spot3));
    }
}