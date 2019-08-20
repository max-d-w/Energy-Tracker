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

    private List<logEntry> log = new ArrayList<>();


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

        logEntry newLog = new logEntry(energyLevel, time);

        day.log.add(newLog);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void logEnergy(int energyLevel, int hour){
        LocalTime time = LocalTime.of(hour, 0);
        logEnergy(energyLevel, time);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void logEnergyNow (int energy){
        LocalTime time = LocalTime.now();
        logEnergy(energy, time);
    }

    public String display(){
        List currLog = this.getLog();
        StringBuffer display = new StringBuffer();

        for (Object l : currLog){
            display.append(((logEntry) l).get_time() + " :  " + ((logEntry) l).get_energy() + "\n");
        }

        return display.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DataPoint[] pointify(){
        DataPoint[] dataPoints = new DataPoint[this.log.size()];

        for (int i = 0; i < this.log.size(); i++){
            logEntry l = this.log.get(i);
            int x = l.get_time().getHour();
            int y = l.get_energy();
            DataPoint datum = new DataPoint(x, y);
            dataPoints[i] = datum;
        }

        return dataPoints;

    }

}
