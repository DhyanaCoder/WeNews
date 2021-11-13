package com.example.thinkpad.wenews;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
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
    PullToRefreshView pullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载内容...");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pullToRefreshView=(PullToRefreshView) findViewById(R.id.pull_to_refresh);

        viewList = new ArrayList<Fragment>();// 将要分页显示的View装入数组中
        final  amusementFragment fragment1=new amusementFragment();
        final  financeFragment  fragment2=new financeFragment();
        final  armyFragment fragment3=new armyFragment();
        final  headlineFragment fragment4=new headlineFragment();
        final  tvFragment fragment5=new tvFragment();
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

        tag=new ArrayList<>();
        tag.add((TextView)findViewById(R.id.finance));
        tag.add((TextView)findViewById(R.id.movie));
        tag.add((TextView)findViewById(R.id.amusement));
        tag.add((TextView)findViewById(R.id.tv));
        tag.add((TextView)findViewById(R.id.headline));
        tag.add((TextView) findViewById(R.id.newsLive));

        pullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {

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
              pullToRefreshView.setRefreshing(false);
            }
        });
    }

}


