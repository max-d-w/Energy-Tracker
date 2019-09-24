package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.jjoe64.graphview.series.DataPoint;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class logger {
    protected Object data;
    protected LocalDateTime dateTime;


    public int getHour(){
        return this.dateTime.getHour();
    }

    public Object getData() {
        return data;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }


    public void timeStamp(){
        this.dateTime = LocalDateTime.now();
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


    public static double roundTime(LocalDateTime dateTime){
        LocalTime time = dateTime.toLocalTime();
        return logger.roundTime(time);
    }


    public abstract DataPoint makePoint();
}


