package com.example.haproslaunchapp;

import android.graphics.Typeface;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.w3c.dom.Text;

public class PageViewerAdapter extends FragmentStateAdapter {

    public PageViewerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        if (position >= 6)
            return new countDownFragment();
        mediaPage frag = new mediaPage(position);

        return frag;
    }
    @Override
    public int getItemCount(){return 7;}

}
