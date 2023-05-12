package com.example.haproslaunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class About_activity extends AppCompatActivity {

    Intent backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.tux_in_home2_resized);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Set text if needed.
        //actionBar.setTitle("[Set Text Here]");
    }

    public void home(View view) {
        backHome = new Intent(About_activity.this, MainActivity.class);
        startActivity(backHome);
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