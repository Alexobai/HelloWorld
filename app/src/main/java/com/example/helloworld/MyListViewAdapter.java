package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MyListViewAdapter extends BaseAdapter {


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    MyListViewAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContext;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvContext = convertView.findViewById(R.id.tv_context);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText("This is title");
        holder.tvTime.setText("This is time");
        holder.tvContext.setText("This is context");
        Glide.with(mContext).load(R.drawable.ic_user).into(holder.imageView);
        return convertView;
    }
}
