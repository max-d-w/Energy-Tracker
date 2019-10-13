package com.example.myapplication.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {energyLog.class}, version = 1, exportSchema = false)
public abstract class energyLogDatabase extends RoomDatabase {

    private static energyLogDatabase instance;

    public abstract energyLogDao energyLogDao();

    public static synchronized energyLogDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    energyLogDatabase.class, "energy_log_database")
                    .allowMainThreadQueries()          // Temporarily allowing main thread queries, fix later
                    .build();
        }

        return instance;
    }

}
