package com.example.myapplication;

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
import android.widget.TextView;

import java.time.LocalDate;
import java.util.List;

public class logView extends AppCompatActivity {
    private energyLogDatabase appDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDB = energyLogDatabase.getInstance(this);

        setContentView(R.layout.activity_log_view);

        String date = getIntent().getExtras().getString("date");

        TextView displayDate = findViewById(R.id.displayDate);
        displayDate.setText(date);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        List<energyLog> day = appDB.energyLogDao().getLogsByDate(date);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(energyLog.pointify(day));
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

}
