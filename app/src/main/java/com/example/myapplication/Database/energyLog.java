package com.example.myapplication.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(tableName = "energy_log_table")
public class energyLog {

    @PrimaryKey
    private LocalTime time;

    private LocalDate date;

    private int energyLevel;

    public energyLog(int energyLevel) {
        this.energyLevel = energyLevel;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }
}
