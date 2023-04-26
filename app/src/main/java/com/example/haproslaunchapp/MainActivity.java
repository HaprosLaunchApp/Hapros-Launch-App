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



       patchLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
           @Override
           public void onScrollChanged() {
               currentPos = patchScrolls.getScrollX();
               Log.d("test", Integer.toString(currentPos));
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
        else if(patch_num == 8){
            //display_patch.setImageResource(R.drawable.patch8);
            main_actionBar.setTitle("Launch VIII");
            about_launch.setText(R.string.launch8_details);
        }
    }





    public void information_page_onclick(View view) {
        if(patch_num != 8){
            information_about = new Intent(MainActivity.this, launch_media_page.class);
            information_about.putExtra("patch_number_data", patch_num);
        }
        else if(patch_num == 8){
            information_about = new Intent(MainActivity.this, countdown_activity.class);
        }
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