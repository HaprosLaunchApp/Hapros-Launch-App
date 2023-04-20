package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class launch_media_page extends AppCompatActivity {
    ActionBar actionBar;
    ViewPager2 pageviewer;
    TabLayout tabLayout;
    PageViewerAdapter viewAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_media_page);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Launch Media Page");

        tabLayout = findViewById(R.id.tab_layout);
        pageviewer = findViewById(R.id.page_viewer);
        viewAdapter = new PageViewerAdapter(this);
        pageviewer.setAdapter(viewAdapter);




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


        
    }
}