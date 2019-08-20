package com.example.myapplication;

import com.jjoe64.graphview.series.DataPoint;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class DayTest {

    private Day d = new Day();

    @Before
    public void setUp(){
        d = new Day();
    }

    @Test
    public void pointify() {
        String[] times = { "7", "10", "12" , "16"};
        int[] energies = {4, 6, 7, 2};
        for (int i = 0; i < times.length; i++){
            d.logEnergy(energies[i], times[i]);
        }

        DataPoint[] data = d.pointify();


    }

}