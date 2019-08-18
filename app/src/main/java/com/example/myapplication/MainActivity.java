package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final Day day = new Day();


    @TargetApi(Build.VERSION_CODES.O)
    public void enterButton(View view){
        SeekBar bar = findViewById(R.id.energy_seek_bar);
        int energy = bar.getProgress();
        day.logEnergyNow(energy);
    }

    public void viewButton(View view){
        List<String> results = day.display();

        for (String item : results) {
            Toast display = Toast.makeText(this, item, Toast.LENGTH_SHORT);
            display.show();
        }
    }
}
