package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.myapplication.Database.energyLog;
import com.example.myapplication.Database.energyLogDatabase;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private energyLogDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        energyLogDatabase appDB = energyLogDatabase.getInstance(this);
    }

    @TargetApi(Build.VERSION_CODES.O)

    // Pressing enter button submits energy level at current time defined by the progress bar

    public void enterButton(View view){
        energyLogDatabase appDB = energyLogDatabase.getInstance(this);
        SeekBar bar = findViewById(R.id.energy_seek_bar);
        int energy = bar.getProgress();

        energyLog newLog = new energyLog(energy);

        appDB.energyLogDao().insert(newLog);

    }

    // View button shows logView activity which graphs all the logs of date in the date field.
    // Defaults to current day if no date is entered.

    public void viewButton(View view){
        Intent viewIntent = new Intent (this, logView.class);
        String date;
        EditText dateInput = findViewById(R.id.dateInput);

        // Default to current date
        if(dateInput.getText().toString().trim().equals("")){
            date = LocalDate.now().toString();
        }
        else{
            String requestedDate = dateInput.getText().toString();

            if (isValidDate(requestedDate) == false){
                dateErrorToast();
                return;
            }
         // Pull date string into array of integers to allow LocalDate to format
            int[] dateArray = retrieveDate(requestedDate);
            try{
                date = LocalDate.of(2000+ dateArray[2], dateArray[1], dateArray[0]).toString();
            }
            catch (DateTimeException ex){
                dateErrorToast();
                return;
            }

        }

        viewIntent.putExtra("date", date);

        startActivity(viewIntent);

    }

    // Checks date format is valid (note: this still allows for false dates, such as 30/02/19,
    // however this is checked by LocalDate.of() method)

    private boolean isValidDate(String input){
        String regex = "^[0-3]?[0-9]/[01]?[0-9]/[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Parses date information from date field.  Converts strings to ints and separates into : [day, month, year]

    private int[] retrieveDate(String input){
        String[] hold = new String[3];
        hold = input.split("/");
        int[] output = new int[3];
        for (int i = 0; i < 3; i++){
            output[i] = Integer.parseInt(hold[i]);
        }
        return output;
    }

    private void dateErrorToast(){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Please enter a valid date", Toast.LENGTH_LONG);
        toast.show();
    }
}
