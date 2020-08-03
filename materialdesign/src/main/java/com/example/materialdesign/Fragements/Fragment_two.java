package com.example.materialdesign.Fragements;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Adapter.MyRecyclerViewAdapters;
import com.example.materialdesign.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Fragment_two extends BaseFragment {
    private List<String> list = new ArrayList<>();
    @BindView(R.id.textinput)
    TextInputLayout textinput;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.design_bottom_sheet1)
    LinearLayout designBottomSheet1;
    @BindView(R.id.tvs)
    RecyclerView tvs;
    private BottomSheetBehavior bottomSheetBehavior;

    public static BaseFragment getInstance() {
        Fragment_two fragment_two = new Fragment_two();

        return fragment_two;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();

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

        bottomSheetBehavior = BottomSheetBehavior.from(designBottomSheet1);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("------", s + "=" + start + "==" + before + "=" + count);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        MyRecyclerViewAdapters myRecyclerViewAdapters = new MyRecyclerViewAdapters(list, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        tvs.setLayoutManager(linearLayoutManager);
        tvs.setAdapter(myRecyclerViewAdapters);
    }

    @Override
    public int getViews() {
        return R.layout.fragment_two;
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {


        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }
}
