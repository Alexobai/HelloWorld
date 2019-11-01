package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mlonglistener;


    public HorizontalAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener longlistener){
        this.mContext = context;
        this.mlistener = listener;
        this.mlonglistener = longlistener;
    }
    @NonNull
    @Override
    public HorizontalAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"clicked"+position,Toast.LENGTH_SHORT).show();
                mlistener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mlonglistener.onClick(position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public LinearViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onClick(int pos);
    }
}
