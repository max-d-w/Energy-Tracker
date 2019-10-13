package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.Database.energyLog;
import com.example.myapplication.Database.energyLogDao;
import com.example.myapplication.Database.energyLogDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.List;

public class logView extends AppCompatActivity {
    private energyLogDatabase appDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        appDB = energyLogDatabase.getInstance(this);

        Intent viewIntent = getIntent();

        String date = viewIntent.getStringExtra("date");

        setContentView(R.layout.activity_log_view);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        List<energyLog> day = appDB.energyLogDao().getLogsByDate(date);

        // Must sort entries by X value to ensure the app doesn't crash

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(energyLog.pointify(day));


        if (series.isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "No Data for Selected Date";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        graph.addSeries(series);

        // Set bounds for the graph view
        graph.getViewport().setMinX(7);
        graph.getViewport().setMaxX(23);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(10);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        // Make datapoints visible on graph
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15f);

    }

    /*public void viewDateButton(View view){
        Intent viewDateIntent = new Intent (this, logView.class);

        EditText dayText = findViewById(R.id.SelectDateDay);
        EditText monthText = findViewById(R.id.SelectDateMonth);
        EditText yearText = findViewById(R.id.SelectDateYear);

        int day = Integer.parseInt(dayText.getText().toString());
        int month = Integer.parseInt(monthText.getText().toString());
        int year = Integer.parseInt(yearText.getText().toString());

        String date = LocalDate.of(year, month, day).toString();

        viewDateIntent.putExtra("date", date);

        startActivity(viewDateIntent);

    }*/

}
