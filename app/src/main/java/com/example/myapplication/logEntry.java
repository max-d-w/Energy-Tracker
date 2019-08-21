package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.jjoe64.graphview.series.DataPoint;

import java.time.LocalTime;

public class logEntry {
    private int _energy;
    private LocalTime _time;

    public String toString(){
        return _energy + " at " +_time.toString() + "\n";
    }

    public int get_energy() {
        return _energy;
    }

    public LocalTime get_time() {
        return _time;
    }

    public void set_energy(int _energy) {
        this._energy = _energy;
    }

    public void set_time(LocalTime _time) {
        this._time = _time;
    }

    // Constructors : if a logEntry is created without a variable for time the time used is the current time

    @RequiresApi(api = Build.VERSION_CODES.O)
    public logEntry(int energy) {
        this._energy = energy;
        this._time = LocalTime.now();
    }

    public logEntry(int energy, LocalTime time){
        this._energy = energy;
        this._time = time;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DataPoint makePoint(){
        int x = this.get_time().getHour();  // Add : if 45 > minutes > 15 , x += .5, if minutes > 45 x+=1 to round to nearest half hour
        int y = this.get_energy();
        DataPoint point = new DataPoint(x, y);

        return point;


    }

}
