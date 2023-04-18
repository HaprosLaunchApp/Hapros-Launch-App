package com.example.haproslaunchapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CountdownActivity extends AppCompatActivity {

    String eventStr;
    DateTimeFormatter fmt;
    TextView days, hours, minutes, seconds;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        days = findViewById(R.id.days_txt_countdown);
        hours = findViewById(R.id.hours_txt_countdown);
        minutes = findViewById(R.id.minutes_txt_countdown);
        seconds = findViewById(R.id.seconds_txt_countdown);

        eventStr = "2023-05-13T08:00:00Z";
        fmt = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        Instant event = fmt.parse(eventStr, Instant::from);

        Handler handler = new Handler();
        handler.post(new Runnable(){

            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void run() {
                Instant now = Instant.now();
                Duration diff = Duration.between(now, event);
                days.setText(String.valueOf(diff.toDays()));
                hours.setText( String.valueOf(diff.toHours() % 24));
                minutes.setText(String.valueOf(diff.toMinutes() % 60));
                seconds.setText(String.valueOf(diff.toSeconds() % 60));
                handler.postDelayed(this,500); // set time here to refresh textView
            }
        });




    }
}