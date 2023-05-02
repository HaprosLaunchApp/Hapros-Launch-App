package com.example.haproslaunchapp;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class countDownFragment extends Fragment {
    String eventStr;
    DateTimeFormatter fmt;
    TextView days, hours, minutes, seconds, untilLaunch;
    Instant event;
    Intent webpage;
    Button websiteButton;
    boolean infoChanged = false;
    public countDownFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_countdown, container, false);
        days = (TextView) view.findViewById(R.id.days_txt_countdown);
        hours = (TextView) view.findViewById(R.id.hours_txt_countdown);
        minutes = (TextView) view.findViewById(R.id.minutes_txt_countdown);
        seconds = (TextView) view.findViewById(R.id.seconds_txt_countdown);
        websiteButton = (Button) view.findViewById(R.id.toLive_bttn_countdown);
        untilLaunch = (TextView) view.findViewById(R.id.untilLaunch_txt_countdown);

        eventStr = "2023-05-13T14:00:00Z";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fmt = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            event = fmt.parse(eventStr, Instant::from);
        }

        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webpage = new Intent();
                webpage.setAction(Intent.ACTION_VIEW);
                webpage.addCategory(Intent.CATEGORY_BROWSABLE);
                webpage.setData(Uri.parse("https://aprs.fi/#!mt=roadmap&z=12&call=a%2FW7CBL-11&timerange=3600&tail=3600"));
                startActivity(webpage);
            }
        });

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
                seconds.setText(String.valueOf(diff.getSeconds() % 60));
                handler.postDelayed(this,500); // set time here to refresh textView

                if((diff.isNegative() || diff.isZero()) && !infoChanged){
                    infoChanged = true;
                    websiteButton.setVisibility(VISIBLE);
                    untilLaunch.setText("Capsule launched!");
                }

            }
        });

        return view;
    }


}