package com.example.haproslaunchapp;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class countDownFragment extends Fragment {
    String eventStr;
    DateTimeFormatter fmt;
    TextView days, hours, minutes, seconds, untilLaunch;
    ImageView bgImage;
    Drawable[] drawables;
    Instant event;
    Intent webpage;
    Button websiteButton;
    boolean infoChanged, pictureChanged = false;
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
        bgImage = (ImageView) view.findViewById(R.id.background_image_countdown);

        drawables = MainActivity.getDrawables(new String[]{"background", "copy_of_hapros_still_2019_2", "copy_of_hapros_still_2019_5", "copy_of_hapros_still_2019", "hapros_still_100k_feet_1","hapros_still_100k_feet_2","save_new_2","save_new_4","save_new_7","hapros_still_100k_feet_3", "hapros_still_95k_feet_with_tux","hapros_still_100k_feet"}, getContext());
        Random rand = new Random();
        int n = rand.nextInt(drawables.length);
        bgImage.setImageDrawable(drawables[n]);
        eventStr = "2023-05-13T14:00:00Z";
        //eventStr = "2023-05-4T15:45:00Z";


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

                if(seconds.getText().equals("0") && !pictureChanged){
                    pictureChanged = true;
                    Random rand = new Random();
                    int n = rand.nextInt(drawables.length);
                    bgImage.setImageDrawable(drawables[n]);
                }
                else if(!seconds.getText().equals("0")){
                    pictureChanged = false;
                }
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