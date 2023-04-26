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
/*import org.json.simple.*;
import org.json.simple.parser.*;*/
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;

public class mediaPage extends Fragment {

    ImageView patch_view;
    VideoView yearVideo_view;
    ImageButton thumnbNail_bttn;

    TextView descHeader_ttv, descPara_ttv;
    Layout desc_layout, scroll_layout;

    int yearID;
    String launchDate, videoFile;

    ArrayList<Dictionary<String,String>> timeLineList;


    String file;


    public mediaPage(int yearID) {
        // Required empty public constructor
        yearID = yearID;
       /* timeLineList = new ArrayList<>();
        file = (Integer.toString(yearID)+"MediaInfo.json");

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject)obj;
            launchDate = (String)jsonObject.get("launchDate");
            videoFile = (String)jsonObject.get("videoDir");
            JSONArray jsonTimeline = (JSONArray)jsonObject.get("postTimeline");
            for (JSONObject string: jsonTimeline) {
                timeLineList.add(string);
            }



        }*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_page, container, false);
    }
}