package com.example.thinkpad.wenews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.R.attr.start;

/**
 * Created by thinkpad on 2019/3/2.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewItem> mNewList;
    private Context mContext;
    static  class ViewHolder extends RecyclerView.ViewHolder{
          ImageView NewsImage;
          TextView  NewsTitle;
        public ViewHolder(View view){
            super(view);
            NewsImage=(ImageView)view.findViewById(R.id.image);
            NewsTitle=(TextView)view.findViewById(R.id.title) ;
        }
    }
    public NewsAdapter(List<NewItem> mNewList){
        this.mNewList=mNewList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        final ViewHolder holder =new ViewHolder(view);
holder.NewsImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int position=holder.getAdapterPosition();
        Intent intent=new Intent(mContext,ContentWebview.class);
        intent.putExtra("address",mNewList.get(position).getContentAddress());
        mContext.startActivity(intent);
    }
});
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewItem news=mNewList.get(position);
        holder.NewsTitle.setText(news.getTitle());
        Glide.with(mContext).load(news.getPictureAddress()).into(holder.NewsImage);
    }

    @Override
    public int getItemCount() {
        return mNewList.size();
    }
}
