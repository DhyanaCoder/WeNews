package com.example.thinkpad.wenews;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by thinkpad on 2019/3/8.
 */

public class channelFragment extends Fragment {
 List<NewItem> newItems=new ArrayList<NewItem>();
 String address;
 NewsAdapter adapter;
    String typeCode;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void GetNews(){
        if(address==null)
            return;
        if(!MainActivity.progressDialog.isShowing()){
            MainActivity.progressDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(MainActivity.progressDialog.isShowing())
                        MainActivity.progressDialog.dismiss();
                }
            },5000);
        }
        HttpUtil.sendOkhttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("RESULT","failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("RESULT","success");
                String text=response.body().string();
                Log.d("response",text);
                parseJSONWithJSONObject(text);
            }
        });
    }
 public void  parseJSONWithJSONObject(String jsonData)
    {
        try{
            Log.d("hello","hello");
            JSONObject jsonObject=new JSONObject(jsonData);
            String reason=jsonObject.getString("reason");
            if(!reason.equals("success!"))
                return;
            JSONObject jsonObject1=jsonObject.getJSONObject("result");
            Log.d("testtest",jsonObject.toString());
            final JSONArray array=jsonObject1.getJSONArray("data");
            for(int i=1;i<array.length();i++)
            {
                NewItem one=new NewItem();
                JSONObject object=array.getJSONObject(i);

                one.setPictureAddress(object.getString("thumbnail_pic_s"));
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
                      Log.d("good!!!!!","showshow!");
                    if(adapter!=null)
                        adapter.notifyDataSetChanged();
                    if(MainActivity.progressDialog.isShowing())
                        MainActivity.progressDialog.dismiss();

                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();

        }
    }
}
