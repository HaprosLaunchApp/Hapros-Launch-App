package com.example.haproslaunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBar main_actionBar;
    TextView swipe_tv, about_launch;
    byte patch_num;
    Intent webpage, about, information_about;
    LinearLayout patchLayout;
    CoolScrollView patchScrolls;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_actionBar = getSupportActionBar();
        patch_num = 1;
        main_actionBar.setTitle("Launch I");

        swipe_tv = findViewById(R.id.swipe_textView);
        about_launch = findViewById(R.id.about_launch_tv);
        about_launch.setText(R.string.launch1_details);
        patchLayout = findViewById(R.id.PatchViewLayout);
        patchScrolls = findViewById(R.id.patch_scroll_main);

        webpage = new Intent();
        about = new Intent(this, About_activity.class);

        patchScrolls.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    patchScrolls.startScrollerTask();
                }

                return false;
            }
        });

        patchScrolls.setOnScrollStoppedListener(new CoolScrollView.OnScrollStoppedListener() {

            public void onScrollStopped() {
                patchScrolls.smoothScrollTo(1150 * (patch_num - 1),0);
            }
        });

        patchLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                swipe_tv.setVisibility(View.INVISIBLE);
                updatePatchNumber();
                updateInformation();
            }
        });


    }


    public void updatePatchNumber(){
        currentPos = patchScrolls.getScrollX();
        // Log.d("test", Integer.toString(currentPos));
        double patch_spacing = 1145.0;
        double patch_center = patch_spacing / 2;
        patch_num = (byte) ((byte) Math.floor(((double) currentPos + patch_center) / patch_spacing) + 1);
    }

    public void updateInformation() {

        if(patch_num == 1){

            main_actionBar.setTitle("Launch I");
            about_launch.setText(R.string.launch1_details);
        }
        else if(patch_num == 2){

            main_actionBar.setTitle("Launch II");
            about_launch.setText(R.string.launch2_details);
        }
        else if(patch_num == 3){
            main_actionBar.setTitle("Launch III");
            about_launch.setText(R.string.launch3_details);
        }
        else if(patch_num == 4){
            main_actionBar.setTitle("Launch IV");
            about_launch.setText(R.string.launch4_details);
        }
        else if(patch_num == 5){
            main_actionBar.setTitle("Launch V");
            about_launch.setText(R.string.launch5_details);
        }
        else if(patch_num == 6){
            main_actionBar.setTitle("Launch VI");
            about_launch.setText(R.string.launch6_details);
        }
        else if(patch_num == 7){
            main_actionBar.setTitle("Launch VII");
            about_launch.setText(R.string.launch7_details);
        }
    }





    public void information_page_onclick(View view) {
        information_about = new Intent(MainActivity.this, launch_media_page.class);
        Log.d("test", Integer.toString(patch_num));
        information_about.putExtra("patch_number_data", patch_num);
        startActivity(information_about);
    }

    public void about_onclick(View view) {
        startActivity(about);
    }

    public void to_tooele_county(View view) {
        webpage.setAction(Intent.ACTION_VIEW);
        webpage.addCategory(Intent.CATEGORY_BROWSABLE);
        webpage.setData(Uri.parse("https://www.facebook.com/tooeleschools"));
        startActivity(webpage);
    }

    public void to_hapros_facebook(View view) {
        webpage.setAction(Intent.ACTION_VIEW);
        webpage.addCategory(Intent.CATEGORY_BROWSABLE);
        webpage.setData(Uri.parse("https://www.facebook.com/TooeleHAPROS"));
        startActivity(webpage);
    }
}