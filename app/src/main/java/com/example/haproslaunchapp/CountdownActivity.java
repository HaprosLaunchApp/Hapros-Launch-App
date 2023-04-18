package com.example.haproslaunchapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CountdownActivity extends AppCompatActivity {

    String eventStr;
    DateTimeFormatter fmt;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        eventStr = "2023-05-13T8:00:00Z";
        fmt = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        Instant event = fmt.parse(eventStr, Instant::from);


    }
}