package com.example.myapplication.Database;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;

public class energyLogRepository {

    private energyLogDao energyLogDao;
    private LiveData<List<energyLog>> allLogs;

    public energyLogRepository(Application application){
        energyLogDatabase database = energyLogDatabase.getInstance(application);
        energyLogDao = database.energyLogDao();
        allLogs = energyLogDao.getAllEnergyLogs();
    }

    public void insert (energyLog log){
        new InsertLogAsyncTask(energyLogDao).execute(log);
    }

    public void update (energyLog log){
        new UpdateLogAsyncTask(energyLogDao).execute(log);
    }

    public void delete (energyLog log){
        new DeleteLogAsyncTask(energyLogDao).execute(log);
    }

    public LiveData<List<energyLog>> getAllLogs(){
        return allLogs;
    }

    private static class InsertLogAsyncTask extends AsyncTask<energyLog, Void, Void>{
        private energyLogDao energyLogDao;

        private InsertLogAsyncTask(energyLogDao energyLogDao){
            this.energyLogDao = energyLogDao;
        }

        @Override
        protected Void doInBackground(energyLog ... logs){
            energyLogDao.insert(logs[0]);
            return null;
        }
    }

    private static class UpdateLogAsyncTask extends AsyncTask<energyLog, Void, Void>{
        private energyLogDao energyLogDao;

        private UpdateLogAsyncTask(energyLogDao energyLogDao){
            this.energyLogDao = energyLogDao;
        }

        @Override
        protected Void doInBackground(energyLog ... logs){
            energyLogDao.update(logs[0]);
            return null;
        }
    }

    private static class DeleteLogAsyncTask extends AsyncTask<energyLog, Void, Void>{
        private energyLogDao energyLogDao;

        private DeleteLogAsyncTask(energyLogDao energyLogDao){
            this.energyLogDao = energyLogDao;
        }

        @Override
        protected Void doInBackground(energyLog ... logs){
            energyLogDao.delete(logs[0]);
            return null;
        }
    }

}
