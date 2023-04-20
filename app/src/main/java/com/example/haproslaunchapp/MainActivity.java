package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBar main_actionBar;
    ImageView display_patch;
    TextView swipe_tv, about_launch;
    byte patch_num;
    Intent webpage, about, information_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_actionBar = getSupportActionBar();
        patch_num = 1;
        main_actionBar.setTitle("Launch I");

        display_patch = findViewById(R.id.show_patch_imageView);
        swipe_tv = findViewById(R.id.swipe_textView);
        about_launch = findViewById(R.id.about_launch_tv);
        about_launch.setText(R.string.launch1_details);

        webpage = new Intent();
        about = new Intent(this, About_activity.class);

    }



    //TODO: replace the temporary buttons with OnSwipe or carrousel.
    public void right_click(View view) {
        patch_num++;
        swipe_tv.setVisibility(View.INVISIBLE);
        if(patch_num > 7){
            patch_num = 1;
        }

        if(patch_num == 1){
            //display_patch.setImageResource(R.drawable.patch1);
            main_actionBar.setTitle("Launch I");
            about_launch.setText(R.string.launch1_details);
        }
        else if(patch_num == 2){
            //display_patch.setImageResource(R.drawable.patch2);
            main_actionBar.setTitle("Launch II");
            about_launch.setText(R.string.launch2_details);
        }
        else if(patch_num == 3){
            //display_patch.setImageResource(R.drawable.patch3);
            main_actionBar.setTitle("Launch III");
            about_launch.setText(R.string.launch3_details);
        }
        else if(patch_num == 4){
            //display_patch.setImageResource(R.drawable.patch4);
            main_actionBar.setTitle("Launch IV");
            about_launch.setText(R.string.launch4_details);
        }
        else if(patch_num == 5){
            //display_patch.setImageResource(R.drawable.patch5);
            main_actionBar.setTitle("Launch V");
            about_launch.setText(R.string.launch5_details);
        }
        else if(patch_num == 6){
            //display_patch.setImageResource(R.drawable.patch6);
            main_actionBar.setTitle("Launch VI");
            about_launch.setText(R.string.launch6_details);
        }
        else if(patch_num == 7){
            //display_patch.setImageResource(R.drawable.patch7);
            main_actionBar.setTitle("Launch VII");
            about_launch.setText(R.string.launch7_details);
        }
    }

    public void left_click(View view) {
        patch_num--;
        swipe_tv.setVisibility(View.INVISIBLE);
        if(patch_num < 1){
            patch_num = 7;
        }

        if(patch_num == 1){
            //display_patch.setImageResource(R.drawable.patch1);
            main_actionBar.setTitle("Launch I");
            about_launch.setText(R.string.launch1_details);
        }
        else if(patch_num == 2){
            //display_patch.setImageResource(R.drawable.patch2);
            main_actionBar.setTitle("Launch II");
            about_launch.setText(R.string.launch2_details);
        }
        else if(patch_num == 3){
            //display_patch.setImageResource(R.drawable.patch3);
            main_actionBar.setTitle("Launch III");
            about_launch.setText(R.string.launch3_details);
        }
        else if(patch_num == 4){
            //display_patch.setImageResource(R.drawable.patch4);
            main_actionBar.setTitle("Launch IV");
            about_launch.setText(R.string.launch4_details);
        }
        else if(patch_num == 5){
            //display_patch.setImageResource(R.drawable.patch5);
            main_actionBar.setTitle("Launch V");
            about_launch.setText(R.string.launch5_details);
        }
        else if(patch_num == 6){
            //display_patch.setImageResource(R.drawable.patch6);
            main_actionBar.setTitle("Launch VI");
            about_launch.setText(R.string.launch6_details);
        }
        else if(patch_num == 7){
            //display_patch.setImageResource(R.drawable.patch7);
            main_actionBar.setTitle("Launch VII");
            about_launch.setText(R.string.launch7_details);
        }
    }

    public void information_page_onclick(View view) {
            information_about = new Intent(MainActivity.this, launch_media_page.class);
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