package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

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
        viewAdapter = new PageViewerAdapter(this);
        pageviewer.setAdapter(viewAdapter);
        backHome = new Intent(launch_media_page.this, MainActivity.class);






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
}