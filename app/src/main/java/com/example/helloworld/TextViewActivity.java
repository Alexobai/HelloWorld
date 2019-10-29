package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTextView4 = findViewById(R.id.tv_4);
        mTextView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTextView4.getPaint().setAntiAlias(true);//get rid of alias

        mTextView5 = findViewById(R.id.tv_5);
        mTextView5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mTextView6 = findViewById(R.id.tv_6);
        mTextView6.setSelected(true);
    }
}
