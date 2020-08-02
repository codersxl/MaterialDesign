package com.example.materialdesign;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.materialdesign.Adapter.ViewPagers;
import com.example.materialdesign.Fragements.BaseFragment;
import com.example.materialdesign.Fragements.Fragment_one;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.wikikii.bannerlib.banner.IndicatorLocation;
import com.wikikii.bannerlib.banner.LoopLayout;
import com.wikikii.bannerlib.banner.LoopStyle;
import com.wikikii.bannerlib.banner.OnDefaultImageViewLoader;
import com.wikikii.bannerlib.banner.bean.BannerInfo;
import com.wikikii.bannerlib.banner.listener.OnBannerItemClickListener;
import com.wikikii.bannerlib.banner.view.BannerBgContainer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener, OnBannerItemClickListener {

    @BindView(R.id.head_layout)
    BannerBgContainer headLayout;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.tablelayout)
    TabLayout tablelayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.loop_layout)
    LoopLayout loopLayout;
    private List<BaseFragment> list = new ArrayList<>();
    private String mTabTitle[] = new String[]{"科技", "游戏", "装备", "创业", "想法"};
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        window = getWindow();
        initDatas();
        initBanner();
//        setToolbar(toolbar);
        initViewpager();
    }

    private void initBanner() {
        // 设置轮播图属性
        loopLayout.setLoop_ms(3000);//轮播的速度(毫秒)
        loopLayout.setLoop_duration(400);//滑动的速率(毫秒)
        loopLayout.setScaleAnimation(true);// 设置是否需要动画
        loopLayout.setLoop_style(LoopStyle.Empty);//轮播的样式-默认empty
        loopLayout.setIndicatorLocation(IndicatorLocation.Center);//指示器位置-中Center
        loopLayout.initializeData(this);
        // 设置轮播图属性end
        // 准备数据
        ArrayList<BannerInfo> bannerInfos = new ArrayList<>();
        List<Object> bgList = new ArrayList<>();
        bannerInfos.add(new BannerInfo(R.mipmap.banner_1, "first"));
        bannerInfos.add(new BannerInfo(R.mipmap.banner_2, "second"));
        bgList.add(R.mipmap.r1);
        bgList.add(R.mipmap.r2);
        // 设置监听
        loopLayout.setOnLoadImageViewListener(new OnDefaultImageViewLoader() {
            @Override
            public void onLoadImageView(ImageView view, Object object) {
                Glide.with(view.getContext())
                        .load(object)
                        .into(view);
            }
        });
        loopLayout.setOnBannerItemClickListener(this);
        if (bannerInfos.size() == 0) {
            return;
        }
        loopLayout.setLoopData(bannerInfos);// 设置轮播数据
        headLayout.setBannerBackBg(this, bgList);// 背景容器设置轮播图片
        loopLayout.setBannerBgContainer(headLayout);// 联动
        loopLayout.startLoop();// 开始循环

    }


//    private void setToolbar(Toolbar toolbar) {
//        setSupportActionBar(toolbar);
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//    }

    private void initViewpager() {
        ViewPagers viewPagers = new ViewPagers(getSupportFragmentManager(), list, mTabTitle);
        viewpager.setAdapter(viewPagers);
        tablelayout.setupWithViewPager(viewpager);
        viewpager.setOffscreenPageLimit(5);

    }

    private void initDatas() {
        for (int i = 0; i < mTabTitle.length; i++) {
            BaseFragment insatnce = Fragment_one.getInsatnce(mTabTitle[i]);
            list.add(insatnce);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        appBarLayout.addOnOffsetChangedListener(this);
        Log.d("-onResume-","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("-onPause-","onPause");
        appBarLayout.removeOnOffsetChangedListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.d("---verticalOffset--", verticalOffset + "");
        if (verticalOffset <= -headLayout.getHeight() / 2) {
            collapsingToolbarLayout.setTitle("hello");
            //使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
            collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
           // window.setStatusBarColor(getResources().getColor(R.color.fuck));
            window.setStatusBarColor(Color.TRANSPARENT);

        } else {
            collapsingToolbarLayout.setTitle("");
            window.setStatusBarColor(Color.TRANSPARENT);

        }
    }

    @Override
    public void onBannerClick(int index, ArrayList<BannerInfo> banner) {

    }
}
