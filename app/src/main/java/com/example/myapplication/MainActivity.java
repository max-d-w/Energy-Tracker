package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.myapplication.Database.energyLog;
import com.example.myapplication.Database.energyLogDatabase;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    private energyLogDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        energyLogDatabase appDB = energyLogDatabase.getInstance(this);
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void enterButton(View view){
        energyLogDatabase appDB = energyLogDatabase.getInstance(this);
        SeekBar bar = findViewById(R.id.energy_seek_bar);
        int energy = bar.getProgress();

        energyLog newLog = new energyLog(energy, LocalTime.now());

        appDB.energyLogDao().insert(newLog);

    }

    public void viewButton(View view){
        Intent viewIntent = new Intent (this, logView.class);
        String date = LocalDate.now().toString();

        viewIntent.putExtra("date", date);

        startActivity(viewIntent);

    }
}
