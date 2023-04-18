package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBar main_actionBar;
    ImageView display_patch;
    TextView swipe_tv;
    byte patch_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_actionBar = getSupportActionBar();
        patch_num = 1;
        main_actionBar.setTitle("Launch I");

        display_patch = findViewById(R.id.show_patch_imageView);
        swipe_tv = findViewById(R.id.swipe_textView);

    }



    //TODO: replace the temporary buttons with OnSwipe or carrousel.
    public void right_click(View view) {
        patch_num++;
        swipe_tv.setVisibility(View.INVISIBLE);
        if(patch_num > 8){
            patch_num = 1;
        }

        if(patch_num == 1){
            //display_patch.setImageResource(R.drawable.patch1);
            main_actionBar.setTitle("Launch I");
        }
        else if(patch_num == 2){
            //display_patch.setImageResource(R.drawable.patch2);
            main_actionBar.setTitle("Launch II");
        }
        else if(patch_num == 3){
            //display_patch.setImageResource(R.drawable.patch3);
            main_actionBar.setTitle("Launch III");
        }
        else if(patch_num == 4){
            //display_patch.setImageResource(R.drawable.patch4);
            main_actionBar.setTitle("Launch IV");
        }
        else if(patch_num == 5){
            //display_patch.setImageResource(R.drawable.patch5);
            main_actionBar.setTitle("Launch V");
        }
        else if(patch_num == 6){
            //display_patch.setImageResource(R.drawable.patch6);
            main_actionBar.setTitle("Launch VI");
        }
        else if(patch_num == 7){
            //display_patch.setImageResource(R.drawable.patch7);
            main_actionBar.setTitle("Launch VII");
        }
        else if(patch_num == 8){
            //display_patch.setImageResource(R.drawable.patch8);
            main_actionBar.setTitle("Launch VIII");
        }
    }

    public void left_click(View view) {
        patch_num--;
        swipe_tv.setVisibility(View.INVISIBLE);
        if(patch_num < 1){
            patch_num = 8;
        }

        if(patch_num == 1){
            //display_patch.setImageResource(R.drawable.patch1);
            main_actionBar.setTitle("Launch I");
        }
        else if(patch_num == 2){
            //display_patch.setImageResource(R.drawable.patch2);
            main_actionBar.setTitle("Launch II");
        }
        else if(patch_num == 3){
            //display_patch.setImageResource(R.drawable.patch3);
            main_actionBar.setTitle("Launch III");
        }
        else if(patch_num == 4){
            //display_patch.setImageResource(R.drawable.patch4);
            main_actionBar.setTitle("Launch IV");
        }
        else if(patch_num == 5){
            //display_patch.setImageResource(R.drawable.patch5);
            main_actionBar.setTitle("Launch V");
        }
        else if(patch_num == 6){
            //display_patch.setImageResource(R.drawable.patch6);
            main_actionBar.setTitle("Launch VI");
        }
        else if(patch_num == 7){
            //display_patch.setImageResource(R.drawable.patch7);
            main_actionBar.setTitle("Launch VII");
        }
        else if(patch_num == 8){
            //display_patch.setImageResource(R.drawable.patch8);
            main_actionBar.setTitle("Launch VIII");
        }
    }
}