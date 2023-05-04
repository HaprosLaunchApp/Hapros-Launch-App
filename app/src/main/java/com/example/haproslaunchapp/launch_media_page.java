package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class launch_media_page extends AppCompatActivity {
    ActionBar actionBar;
    ViewPager2 pageviewer;
    TabLayout tabLayout;
    PageViewerAdapter viewAdapter;
    Intent backHome;

    byte year;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_media_page);
        Bundle bundle = getIntent().getExtras();
        year = bundle.getByte("patch_number_data");
        actionBar = getSupportActionBar();

        tabLayout = findViewById(R.id.tab_layout);
        pageviewer = findViewById(R.id.page_viewer);
        viewAdapter = new PageViewerAdapter(this,getApplicationContext());
        pageviewer.setAdapter(viewAdapter);
        backHome = new Intent(launch_media_page.this, MainActivity.class);



        // The pictures won't display because they are all greyed out.
        tabLayout.getTabAt(0).setIcon(R.drawable.roman_numerals_i);
        tabLayout.getTabAt(1).setIcon(R.drawable.roman_numerals_ii);
        tabLayout.getTabAt(2).setIcon(R.drawable.roman_numerals_iii);
        tabLayout.getTabAt(3).setIcon(R.drawable.roman_numerals_iv);
        tabLayout.getTabAt(4).setIcon(R.drawable.roman_numerals_v);
        tabLayout.getTabAt(5).setIcon(R.drawable.roman_numerals_vi);
        tabLayout.getTabAt(6).setIcon(R.drawable.roman_numerals_vii);
        tabLayout.getTabAt(7).setIcon(R.drawable.home_icon);







        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                pageviewer.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
        pageviewer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        tabLayout.selectTab(tabLayout.getTabAt(year-1));

    }
    public void back_to_home(View view) {
        startActivity(new Intent(launch_media_page.this,MainActivity.class));
    }
}