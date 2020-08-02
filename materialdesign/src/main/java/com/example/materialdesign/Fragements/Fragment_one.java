package com.example.materialdesign.Fragements;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Adapter.MyRecyclerViewAdapters;
import com.example.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_one extends BaseFragment {


    @BindView(R.id.tv)
    RecyclerView tv;
    private String key;
    private List<String> list = new ArrayList<>();

    public static BaseFragment getInsatnce(String i) {
        Fragment_one fragment_one = new Fragment_one();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", i);
        fragment_one.setArguments(bundle);
        return fragment_one;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        key = arguments.getString("KEY");
        Log.d("--", key + "");
        InitList();

    }





    private void InitList() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    list.add("这是第" + i + "条");
                }
            }
        }.start();
    }


    @Override
    protected void show() {
        MyRecyclerViewAdapters myRecyclerViewAdapters = new MyRecyclerViewAdapters( list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        tv.setLayoutManager(linearLayoutManager);
        tv.setAdapter(myRecyclerViewAdapters);
    }

    @Override
    public int getViews() {
        return R.layout.fragment_one;
    }

    @Override
    public void getData() {
        super.getData();

    }
}
