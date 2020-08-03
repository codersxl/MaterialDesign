package com.example.materialdesign.Fragements;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.materialdesign.R;

public class Fragemnt_three extends BaseFragment {

    public static BaseFragment getInstance() {
        Fragemnt_three fragment_two = new Fragemnt_three();

        return fragment_two;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();



    }




    @Override
    protected void show() {

    }

    @Override
    public int getViews() {
        return R.layout.fragment_three;
    }
}
