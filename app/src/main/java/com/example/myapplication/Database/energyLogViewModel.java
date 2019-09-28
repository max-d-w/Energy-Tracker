package com.example.myapplication.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class energyLogViewModel extends AndroidViewModel {

    private energyLogRepository repository;
    private LiveData<List<energyLog>> allLogs;


    public energyLogViewModel(@NonNull Application application){
        super(application);
        repository = new energyLogRepository(application);
        allLogs = repository.getAllLogs();
    }

    public void insert(energyLog log){
        repository.insert(log);
    }

    public void update(energyLog log){
        repository.update(log);
    }

    public void delete(energyLog log){
        repository.delete(log);
    }

    public LiveData<List<energyLog>> getAllLogs() {
        return allLogs;
    }
}
