package io.github.valtergabriell.mslogin.application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditServiceTest {


    @Test
    void itShouldReturnDifferenceBetweenYears() {
        int year = LocalDate.of(2022, 04, 03).getYear();
        int currentYeat = LocalDate.now().getYear();
        int total = currentYeat - year;
        assertEquals(1, total);
    }


}