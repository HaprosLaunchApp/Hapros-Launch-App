package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBar main_actionBar;
    TextView swipe_tv, about_launch, launchTitle;
    byte patch_num;
    Intent webpage, about, information_about;
    LinearLayout patchLayout;
    ScrollView scrollView;
    HorizontalScrollView patchScrolls;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_actionBar = getSupportActionBar();
        patch_num = 1;
        main_actionBar.setTitle("Launch I");

        swipe_tv = findViewById(R.id.swipe_textView);
        scrollView = findViewById(R.id.scroll_main);
        launchTitle = findViewById(R.id.launchTitle_txt_main);
        about_launch = findViewById(R.id.about_launch_tv2);
        about_launch.setText(R.string.launch1_details);
        patchLayout = findViewById(R.id.PatchViewLayout);
        patchScrolls = findViewById(R.id.patch_scroll);

        webpage = new Intent();
        about = new Intent(this, About_activity.class);



        patchLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                currentPos = patchScrolls.getScrollX();
                swipe_tv.setVisibility(View.INVISIBLE);
                if(currentPos > 0 && currentPos < 550){
                    patch_num = 1;
                }
                if(currentPos >= 550 && currentPos < 1670){
                    patch_num = 2;
                }
                if(currentPos >= 1670 && currentPos < 2755){
                    patch_num = 3;
                }
                if(currentPos >= 2755 && currentPos < 3848){
                    patch_num = 4;
                }
                if(currentPos >= 3848 && currentPos < 4983){
                    patch_num = 5;
                }
                if(currentPos >= 4983 && currentPos < 6018){
                    patch_num = 6;
                }
                if(currentPos >= 6018){
                    patch_num = 7;
                }
                updateInformation();
            }
        });

    }




    public void updateInformation() {
        if(patch_num == 1){

            main_actionBar.setTitle("Launch I");
            about_launch.setText(R.string.launch1_details);
            launchTitle.setText(R.string.launch1_title);
        }
        else if(patch_num == 2){

            main_actionBar.setTitle("Launch II");
            about_launch.setText(R.string.launch2_details);
            launchTitle.setText(R.string.launch2_title);
        }
        else if(patch_num == 3){
            main_actionBar.setTitle("Launch III");
            about_launch.setText(R.string.launch3_details);
            launchTitle.setText(R.string.launch3_title);
        }
        else if(patch_num == 4){
            main_actionBar.setTitle("Launch IV");
            about_launch.setText(R.string.launch4_details);
            launchTitle.setText(R.string.launch4_title);
        }
        else if(patch_num == 5){
            main_actionBar.setTitle("Launch V");
            about_launch.setText(R.string.launch5_details);
            launchTitle.setText(R.string.launch5_title);
        }
        else if(patch_num == 6){
            main_actionBar.setTitle("Launch VI");
            about_launch.setText(R.string.launch6_details);
            launchTitle.setText(R.string.launch6_title);
        }
        else if(patch_num == 7){
            main_actionBar.setTitle("Launch VII");
            about_launch.setText(R.string.launch7_details);
            launchTitle.setText(R.string.launch7_title);
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