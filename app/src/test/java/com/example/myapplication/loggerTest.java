package com.example.myapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class loggerTest {

    @Test
    void testRoundTime() {
        final LocalTime time1 = LocalTime.of(10, 47);
        final LocalTime time2 = LocalTime.of(8, 14);
        final LocalTime time3 = LocalTime.of(7, 29);

        LocalTime[] times = {time1, time2, time3};

        final float[] expected = {11, 8, (float) 7.5};

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(logger.roundTime(times[i]), expected[i], 0.05);
        }
    }
}