package com.example.haproslaunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBar main_actionBar;
    TextView swipe_tv, about_launch, launchTitle;
    ImageView spaceImage;
    byte patch_num;
    Drawable[] drawables;
    Intent webpage, about, information_about;
    LinearLayout patchLayout;
    CoolScrollView patchScrolls;
    ScrollView scrollView;
    int currentPos;
    int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_actionBar = getSupportActionBar();
        patch_num = 1;
        { // Get screen width
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            screenWidth = displayMetrics.widthPixels;
        }

        main_actionBar.setTitle("HAPROS");

        drawables = getDrawables(new String[]{"save_new_2", "save_new_7", "haprosiii_view", "hapros_thumbnail_2", "hapros_still_100k_feet_3", "copy_of_hapros_still_2019_5", "save_new_4"}, getApplicationContext());

        spaceImage = findViewById(R.id.space_img_main);
        swipe_tv = findViewById(R.id.swipe_textView);
        scrollView = findViewById(R.id.scroll_main);
        launchTitle = findViewById(R.id.launchTitle_txt_main);
        about_launch = findViewById(R.id.about_launch_tv2);
        about_launch.setText(R.string.launch1_details);
        patchLayout = findViewById(R.id.PatchViewLayout);
        patchScrolls = findViewById(R.id.patch_scroll_main);

        webpage = new Intent();
        about = new Intent(this, About_activity.class);


        // Add listener functionality to the patches scroll view
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

    public static Drawable[] getDrawables(String[] strings, Context context){
        Drawable[] drawables = new Drawable[strings.length];
        for(int i = 0; i < drawables.length; i++){
            int resourceId = context.getResources().getIdentifier(strings[i], "drawable", context.getPackageName());
            drawables[i] = ResourcesCompat.getDrawable(context.getResources(), resourceId, null);
        }
        return drawables;
    }


    public void updatePatchNumber(){
        currentPos = patchScrolls.getScrollX();
        // Log.d("test", Integer.toString(currentPos));
        double patch_spacing = 1145.0;
        double patch_center = patch_spacing / 2;
        patch_num = (byte) ((byte) Math.floor(((double) currentPos + patch_center) / patch_spacing) + 1);
    }

    public void updateInformation() {
        spaceImage.setImageDrawable(drawables[patch_num - 1]);
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
        // add `else if (patch_num == 8/9/10/...){ main_actionBar.setTitle("HAPROS VIII/IX/X/XI/XII/XIII/XIV") ... }` for new patches
        // TODO connect info strings to the text views for new years

    }





    // Button functionality
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