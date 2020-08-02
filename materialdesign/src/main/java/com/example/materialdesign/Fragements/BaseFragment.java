package com.example.materialdesign.Fragements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

public abstract  class BaseFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getViews(), container, false);
        ButterKnife.bind(this,inflate);
        getData();
        return inflate;
    }

    public   void getData(){

    };

    @Override
    public void onResume() {
        super.onResume();
              show();
    }

    protected abstract void show();

    public abstract int getViews();

}
