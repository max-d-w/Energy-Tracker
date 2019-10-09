package com.example.myapplication.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Database.energyLog;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface energyLogDao {

    @Insert
    void insert (energyLog log);

    @Update
    void update (energyLog log);

    @Delete
    void delete (energyLog log);

    @Query("SELECT * FROM energy_log_table")
    List<energyLog> getAllEnergyLogs();

    @Query("SELECT * FROM energy_log_table WHERE date LIKE :thisDate")
    List<energyLog> getLogsByDate(String thisDate);
}
