package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public logEntry(int energy) {
        this._energy = energy;
        this._time = LocalTime.now();
    }

    public logEntry(int energy, LocalTime time){
        this._energy = energy;
        this._time = time;
    }



}
