package com.example.haproslaunchapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class mediaPage extends Fragment {

    ImageView patch_view;
    VideoView yearVideo_view;
    ImageButton thumnbNail_bttn;

    TextView descHeader_ttv, descPara_ttv;
    Layout desc_layout, scroll_layout;

    int yearID;

    public mediaPage(int yearID) {
        // Required empty public constructor
        yearID = yearID;




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_page, container, false);
    }
}