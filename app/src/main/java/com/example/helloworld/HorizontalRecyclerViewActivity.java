package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        mRecyclerViewHorizontal = findViewById(R.id.rv_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizontalRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewHorizontal.setLayoutManager(linearLayoutManager);
        mRecyclerViewHorizontal.addItemDecoration(new MyDecoration());
        mRecyclerViewHorizontal.setAdapter(new HorizontalAdapter(HorizontalRecyclerViewActivity.this, new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecyclerViewActivity.this, "clicked" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new HorizontalAdapter.OnItemLongClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecyclerViewActivity.this, "pressed" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}

