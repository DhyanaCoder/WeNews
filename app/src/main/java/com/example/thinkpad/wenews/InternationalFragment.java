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

public class InternationalFragment extends channelFragment {

    private  RecyclerView recyclerView_tv;


    public InternationalFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_tv, container, false);
        recyclerView_tv=(RecyclerView) view.findViewById(R.id.recyclerview_tv) ;
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView_tv.setLayoutManager(layoutManager);
        adapter=new NewsAdapter(newItems);
        recyclerView_tv.setAdapter(adapter);
        setAddress("https://v.juhe.cn/toutiao/index?type=guoji&key=159fcc069e8f11876501f359679b449f");
        GetNews();
        return view;
    }

/*public void GetNews(){
    if(!MainActivity.progressDialog.isShowing()){
        MainActivity.progressDialog.show();
    }
    HttpUtil.sendOkhttpRequest("https://3g.163.com/touch/reconstruct/article/list/BD2A86BEwangning/0-20.html", new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d("error11","获取错误！！！");
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.d("成功！","12121212");
            String text=response.body().string();
            Log.d("response",text);
            char test[]=text.toCharArray();
            for(int i=0;i<9;i++)
                test[i]=' ';
            test[test.length-1]=' ';
            Log.d("text",String.valueOf(test));
            text=String.valueOf(test);
            parseJSONWithJSONObject(text);
        }
    });
}
   public   void  parseJSONWithJSONObject(String jsonData)
    {
        try{
            Log.d("hello","hello");
            JSONObject jsonObject=new JSONObject(jsonData);

            Log.d("testtest",jsonObject.toString());
            final JSONArray array=jsonObject.getJSONArray("BD2A86BEwangning");
            for(int i=1;i<array.length();i++)
            {
                NewItem one=new NewItem();
                JSONObject object=array.getJSONObject(i);

                one.setPictureAddress(object.getString("imgsrc"));
                one.setTitle(object.getString("title"));
                one.setContentAddress(object.getString("url"));
                Log.d("contentadress",one.getContentAddress());
                if(one.getContentAddress().toCharArray()[0]=='0')//对无用的内容地址object进筛选
                {
                    Log.d("goodnull","truetrue!+");
                    continue;

                }
                Log.d("title12",one.getTitle());
                Log.d("pic12",one.getPictureAddress());
                boolean check=false;
                for(NewItem c:newItems){
                    if(c.getTitle().equals(one.getTitle())){
                        check=true;
                    break;
                }}
                if(!check)
                newItems.add(one);
            }

            Log.d("listsize","1234"+" "+newItems.size());
           getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(MainActivity.progressDialog.isShowing())
                        MainActivity.progressDialog.dismiss();
                    adapter.notifyDataSetChanged();
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();

        }
    }*/
}
