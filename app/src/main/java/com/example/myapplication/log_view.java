package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class log_view extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        Day day = Day.getDay();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(day.pointify());
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
