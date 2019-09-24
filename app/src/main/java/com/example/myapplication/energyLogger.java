package com.example.myapplication;

import com.jjoe64.graphview.series.DataPoint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class energyLogger extends logger {

    public int getEnergyLevel() {
        return (int) this.data;
    }

    public energyLogger (int energyLevel){
        this.data = energyLevel;
        this.dateTime = LocalDateTime.now();
    }

    public energyLogger (int energyLevel, LocalTime time){
        this.data = energyLevel;
        this.dateTime = time.atDate(LocalDate.now());
    }

    public DataPoint makePoint(){
        double x = logger.roundTime(this.getDateTime());
        double y = this.getEnergyLevel();
        DataPoint point = new DataPoint(x, y);

        return point;

    }

    public String toString(){
        return this.getEnergyLevel() + " at " + this.getDateTime().toString() + "\n";
    }

}
