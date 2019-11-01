package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear;
    private Button mBtnHorizontal;
    private Button mBtnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnHorizontal = findViewById(R.id.btn_horizontal);
        mBtnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorizontalRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
