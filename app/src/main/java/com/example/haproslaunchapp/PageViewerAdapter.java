package com.example.haproslaunchapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageViewerAdapter extends FragmentStateAdapter {

    public PageViewerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch(position){
            case 0:
                return new mediaPage(1);
            case 1:
                return new mediaPage(2);
            case 2:
                return new mediaPage(3);
            case 3:
                return new mediaPage(4);
            case 4:
                return new mediaPage(5);
            case 5:
                return new mediaPage(6);
            case 6:
                return new countDownFragment();
            case 7:
                return new back_home_fragment();
            default:
                return new countDownFragment();
        }
    }
    @Override
    public int getItemCount(){return 8;}

}
