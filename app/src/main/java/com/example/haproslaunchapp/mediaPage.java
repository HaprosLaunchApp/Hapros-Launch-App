package com.example.haproslaunchapp;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import org.json.simple.*;
import org.json.simple.parser.*;
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
    ScrollView scrollView;

    ArrayList<Dictionary<String,String>> timeLineData;
    ArrayList<MediaPost> timeLineList;

    Context context;


    String file;


    public mediaPage(int yearID, Context context) {
        this.context = context;
        // Required empty public constructor
        this.yearID = yearID;
        timeLineData = new ArrayList<>();
        timeLineList = new ArrayList<>();
//        timelineCreate();
//        for (Dictionary<String,String> dict: timeLineData) {
//            MediaPost post = new MediaPost(dict.get("imgDir"),dict.get("date"),dict.get("postDescription"));
//            timeLineList.add(post);
//
//        }

        System.out.println("Before Trying");
        file = loadJSONFromAsset();

        JSONParser parser = new JSONParser();
        try{
            System.out.println(file);
            Object obj = parser.parse(file);
            System.out.println("parsed");

            JSONObject jsonObject = (JSONObject)obj;
            launchDate = (String)jsonObject.get("launchDate");
            videoFile = (String)jsonObject.get("videoDir");
            JSONArray jsonTimeline = (JSONArray)jsonObject.get("postTimeline");
            System.out.println("After getting objects");
            for (int i = 0; i < jsonTimeline.size(); i++) {

                JSONObject postObj = (JSONObject) jsonTimeline.get(i);

                String iImgDate = (String) postObj.get("date");
                String iImgDir = (String) postObj.get("imgDir");
                String iPostDesc = (String) postObj.get("postDescription");

                MediaPost x = new MediaPost(iImgDir,iImgDate,iPostDesc);
                timeLineList.add(x);
                System.out.println((iImgDate+iImgDir+iPostDesc));

            }
            System.out.println("After for-loop");

        }catch(Exception e) {
            System.out.print(e);
            System.out.println("FAILED TO DO SOMETHING");

        }
        if (timeLineList.size() > 0) {
            for (MediaPost post : timeLineList) {
                System.out.println(post.getImageDir());
                System.out.println(post.getPostDate());
                System.out.println(post.getPostDesc());
            }
        }
        System.out.println("bottom of constructor");



    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            System.out.println("Pre-iS");
            Log.d("test", context.getResources().getAssets().toString());
            String fileName = Integer.toString(yearID+1)+"MediaInfo.json";
            InputStream is = context.getResources().getAssets().open("json/"+fileName);
            System.out.println("after-iS");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            System.out.println("after read");

            is.close();
            json = new String(buffer, "UTF-8");
            System.out.println("afterString");

        } catch (IOException ex) {
            System.out.println("Pre-iS");
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public ArrayList<MediaPost> getTimeLineList() {
        return timeLineList;
    }

    private void timelineCreate(){
        //Manually creating the data like this is temporary and will be changed later on
        Dictionary<String,String>  x = new Hashtable<>();
        x.put("date","May, 4, 2022");
        x.put("imgDir","0504022.png");
        x.put("postDescription","This is a small example post to use for each picture, this is where you will write a couple of sentences to describe the post.");
        timeLineData.add(x);
        Dictionary<String,String> z = new Hashtable<>();
        z.put("date","May, 14, 2022");
        z.put("imgDir","0514022.png");
        z.put("postDescription","This is a small example post to use for each picture, this is where you will write a couple of sentences to describe the post.");
        timeLineData.add(z);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_media_page, container, false);
        LinearLayout scrollView = (LinearLayout) view.findViewById(R.id.scroll_layout);
        VideoView videoView = (VideoView) view.findViewById(R.id.mainVideoView);
        Log.d("test", videoFile);
        String videoPath = "android.resource://"+ context.getPackageName()+"/raw/"+videoFile;
        videoView.setVideoPath(videoPath);

        MediaController mediaController = new MediaController(videoView.getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.pause();

//        videoView.start();
//        videoView.pause();
//        videoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!videoView.isPlaying()){
//                    videoView.start();
//                }else{
//                    videoView.pause();
//                }
//            }
//        });



        for (MediaPost post: getTimeLineList()) {
            LinearLayout postLayout = new LinearLayout(view.getContext());
            postLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView postImg = new ImageView(postLayout.getContext());
            TextView dateHead = new TextView(postLayout.getContext());
            TextView postDesc = new TextView(postLayout.getContext());
            postImg.setScaleType(ImageView.ScaleType.FIT_CENTER);
            postImg.setMaxWidth(182);

            String uri = post.getImageDir();
            Log.d("test", uri);
            int imgres = getResources().getIdentifier("drawable/"+uri,null,getContext().getPackageName());

            Drawable imgDraw = getResources().getDrawable(imgres);
            postImg.setImageDrawable(imgDraw);
            postImg.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 350));
            postImg.setScaleType(ImageView.ScaleType.FIT_CENTER);

            postLayout.addView(postImg);
            dateHead.setTextSize(24);
            dateHead.setTypeface(dateHead.getTypeface(), Typeface.BOLD);
            dateHead.setText(post.getPostDate());
            postLayout.addView(dateHead);
            postDesc.setTextSize(16);
            postDesc.setText(post.getPostDesc());
            postLayout.addView(postDesc);
            scrollView.addView(postLayout);
        }


        return view;
    }
}