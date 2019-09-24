package com.example.myapplication;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.jjoe64.graphview.series.DataPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Day {


    public static Day day = new Day();


        /* Represents the log for one day
        Stores date and an arraylist of log entries, each with a time and an energy level
        */

    // private LocalDate day; // ignore day until log is functional.

    private List<logger> log = new ArrayList<>();


    /*public LocalDate getDay() {
        return day;
    }
*/

    public List getLog() {
        return log;
    }

    /*
    public Day(LocalDate day) {
        this.day = day;
    }
*/

    /*@TargetApi(Build.VERSION_CODES.O)
    public Day(){
        this.day = LocalDate.now();
    }
*/

    public static Day getDay() {
        return day;
    }

    public static void logEnergy(int energyLevel, LocalTime time){

        energyLogger newLog = new energyLogger(energyLevel, time);

        day.log.add(newLog);
    }

    public static void logEnergy(int energyLevel, int hour){
        LocalTime time = LocalTime.of(hour, 0);
        logEnergy(energyLevel, time);

    }

    public static void logEnergyNow (int energy){
        LocalTime time = LocalTime.now();
        logEnergy(energy, time);
    }


    public DataPoint[] pointify(){

        DataPoint[] dataPoints = new DataPoint[this.log.size()];

        if (this.log.size() == 0){
            return dataPoints;
        }

        for (int i = 0; i < this.log.size(); i++){

            DataPoint point = this.log.get(i).makePoint();

            dataPoints[i] = point;
        }

        // DataPoints put into graphview need to be sorted according to x values



        return dataPoints;

    }


}
