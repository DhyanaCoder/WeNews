package com.example.thinkpad.wenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2019/3/3.
 */

public class channelPager extends FragmentPagerAdapter {
    List<Fragment> fragmentList=new ArrayList<>();
    MainActivity mContext;
    public  channelPager(FragmentManager fm , List<Fragment> list,MainActivity mContext)
    {
        super(fm);
        fragmentList=list;
        this.mContext=mContext;
    }
    @Override
    public Fragment getItem(int position) {
        Log.d("getItem","good");

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList!= null ? fragmentList.size() : 0;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        MainActivity.tagPointer=position;
        switch (position) {
            case 0: {
                MainActivity.tag.get(0).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(0);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }}
            break;
            case 1: {
                MainActivity.tag.get(1).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(1);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }

            }
            break;
            case 2: {
                MainActivity.tag.get(2).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(2);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }

            }
            break;
            case 3: {
                MainActivity.tag.get(3).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(3);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }

            }
            break;
            case 4: {
                MainActivity.tag.get(4).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(4);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }

            }
            break;
            case 5: {
                MainActivity.tag.get(5).setBackgroundColor(mContext.getResources().getColor(R.color.colorDark));
                List<TextView> others = new ArrayList<TextView>();
                others.addAll(MainActivity.tag);
                others.remove(5);
                for (TextView textView : others) {
                    textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                }

            }
            break;
        }
    }
}
