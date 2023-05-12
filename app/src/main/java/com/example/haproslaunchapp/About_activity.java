package com.example.haproslaunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

public class About_activity extends AppCompatActivity {

    Intent backHome;
    ScrollView scrollView_about_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.tux_in_home2_resized);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("About HAPROS");

        scrollView_about_page = findViewById(R.id.scrollViewAbout);
        scrollView_about_page.setVerticalScrollbarPosition(0);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}