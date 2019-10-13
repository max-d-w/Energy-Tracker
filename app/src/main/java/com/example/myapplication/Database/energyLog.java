package com.example.myapplication.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.jjoe64.graphview.series.DataPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(tableName = "energy_log_table", primaryKeys = {"time", "date"})
public class energyLog {

    @NonNull
    private String time;

    @NonNull
    private String date;

    private int energyLevel;

    public energyLog(int energyLevel) {
        this.energyLevel = energyLevel;
        this.date = LocalDate.now().toString();
        this.time = LocalTime.now().toString();
    }

    public energyLog(int energyLevel, LocalTime time) {
        this.energyLevel = energyLevel;
        this.date = LocalDate.now().toString();
        this.time = time.toString();
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static double roundTime(LocalTime time){
        if (time.getMinute() >= 45){
            return time.getHour() + 1;
        }
        else if (time.getMinute() >= 15){
            return time.getHour() + 0.5;
        }
        return time.getHour();
    }

    public DataPoint makePoint(){
        double x = energyLog.roundTime(LocalTime.parse(this.getTime()));
        double y = this.getEnergyLevel();
        DataPoint point = new DataPoint(x, y);

        return point;

    }

    public static DataPoint[] pointify(List<energyLog> logs){

        DataPoint[] dataPoints = new DataPoint[logs.size()];

        for (int i = 0; i < logs.size(); i++){

            DataPoint point = logs.get(i).makePoint();

            dataPoints[i] = point;
        }

        // DataPoints put into graphview need to be sorted according to x values



        return dataPoints;

    }

}
