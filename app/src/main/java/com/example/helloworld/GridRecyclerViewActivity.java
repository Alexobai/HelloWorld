package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRecyclerViewGrid = findViewById(R.id.rv_grid);
        mRecyclerViewGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        mRecyclerViewGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"clicked"+pos, Toast.LENGTH_SHORT).show();
            }
        }, new GridAdapter.OnItemLongClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"clicked"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
        mRecyclerViewGrid.addItemDecoration(new MyDecoration());
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
