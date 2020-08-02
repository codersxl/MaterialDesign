package com.example.materialdesign.Adapter;

import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.materialdesign.Fragements.BaseFragment;

import java.util.List;


public class ViewPagers extends FragmentPagerAdapter {
    private final List<BaseFragment> list;
    private final String[] mTabTitle;


    public ViewPagers(@NonNull FragmentManager fm, List<BaseFragment> list, String[] mTabTitle) {
        super(fm);
        this.list=list;
        this.mTabTitle=mTabTitle;
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle[position];
    }
}
