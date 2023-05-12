package com.example.haproslaunchapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageViewerAdapter extends FragmentStateAdapter {
    Context context;
    public PageViewerAdapter(@NonNull FragmentActivity fragmentActivity, Context context){
        super(fragmentActivity);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // the if position >= 6 line below determines when to use the countdown fragment and when to use the mediaPage fragment
        // position reflects the currently selected tab in the activity_launch_media_page.xml starting from 0
        // TODO increase\/ the below number to be the current year -1
        if (position >= 6) {
            return new countDownFragment();
        }

        mediaPage frag = new mediaPage(position,context);

        return frag;

    }

    @Override
    public int getItemCount(){return 7;}

}
