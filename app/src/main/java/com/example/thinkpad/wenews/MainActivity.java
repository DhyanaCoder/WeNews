package com.example.thinkpad.wenews;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    static List<TextView> tag;
    List<Fragment> viewList;
    static   int tagPointer=0;
    static  ProgressDialog  progressDialog ;
    TabLayout tabLayout;
    private SwipeRefreshLayout mSwipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载内容...");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mSwipeLayout=(SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        viewList = new ArrayList<Fragment>();// 将要分页显示的View装入数组中
        final  amusementFragment fragment1=new amusementFragment();
        final  financeFragment  fragment2=new financeFragment();
        final  armyFragment fragment3=new armyFragment();
        final  headlineFragment fragment4=new headlineFragment();
        final  InternationalFragment fragment5=new InternationalFragment();
        final  newsFragment fragment6=new newsFragment();

        viewList.add(fragment2);
        viewList.add(fragment3);
        viewList.add(fragment1);
        viewList.add(fragment5);
        viewList.add(fragment4);
        viewList.add(fragment6);

        FragmentManager fragmentManager=getSupportFragmentManager();
        channelPager pagerAdapter=new channelPager(fragmentManager,viewList,this);
        viewPager.setAdapter(pagerAdapter);

        //设置加载动画背景颜色
        mSwipeLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(android.R.color.background_light));
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            public void onRefresh() {
                switch (tagPointer){
                  case 0:
                      fragment1.GetNews();
                      break;
                  case 1:
                      fragment2.GetNews();
                      break;
                  case 2:
                      fragment3.GetNews();
                      break;
                  case 3:
                      fragment4.GetNews();
                      break;
                  case 4:
                      fragment5.GetNews();
                      break;
                  case 5:
                      break;
              }
              mSwipeLayout.setRefreshing(false);
            }
        });
    }

}


