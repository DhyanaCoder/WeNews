package com.example.thinkpad.wenews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class headlineFragment extends channelFragment {

    private  RecyclerView recyclerView_sports;


    public headlineFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_sports, container, false);
        recyclerView_sports=(RecyclerView) view.findViewById(R.id.recyclerview_sports) ;
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView_sports.setLayoutManager(layoutManager);
        adapter=new NewsAdapter(newItems);
        recyclerView_sports.setAdapter(adapter);
        address="https://v.juhe.cn/toutiao/index?type=top&key=159fcc069e8f11876501f359679b449f";
        GetNews();
        return view;
    }

}
