package com.example.haproslaunchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class About_activity extends AppCompatActivity {

    ActionBar actionBar;
    Intent backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        actionBar = getSupportActionBar();
        actionBar.setTitle("About HAPROS");
    }

    public void home(View view) {
        backHome = new Intent(About_activity.this, MainActivity.class);
        startActivity(backHome);
    }
}