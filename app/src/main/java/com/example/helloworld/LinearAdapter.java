package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mlonglistener;


    public LinearAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener longlistener){
        this.mContext = context;
        this.mlistener = listener;
        this.mlonglistener = longlistener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            ((LinearViewHolder)holder).textView.setText("Hello World!");

        }else{
            ((LinearViewHolder2)holder).textView.setText("Hello World2!");
        }
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
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }

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


    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public LinearViewHolder2(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onClick(int pos);
    }
}
