package com.example.myapplication;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Day {

        /* Represents the log for one day
        Stores date and an arraylist of log entries, each with a time and an energy level
        */

    public class logEntry {
        private int _energy;
        private LocalTime _time;

        public String toString(){
            return _energy + " at " +_time.toString() + "\n";
        }

    }

    private LocalDate day;
    private List<logEntry> log = new ArrayList<>();

    public LocalDate getDay() {
        return day;
    }

    public List getLog() {
        return log;
    }

    public Day(LocalDate day) {
        this.day = day;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public Day(){
        this.day = LocalDate.now();
    }



    public void logEnergy(int energyLevel, LocalTime time){

        logEntry newLog = new logEntry();
        newLog._energy =  energyLevel;
        newLog._time = time ;


        this.log.add(newLog);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void logEnergyNow (int energy){
        LocalTime time = LocalTime.now();
        logEnergy(energy, time);
    }

    public List<String> display(){
        List currLog = this.getLog();
        List<String> display = new ArrayList<>();

        for (Object l : currLog){
            display.add(l.toString());
        }
        return display;
    }

}
