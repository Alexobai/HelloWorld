package com.example.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private AFragment aFragment;
    private TextView mTextViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mTextViewTitle = findViewById(R.id.tv_title);



        aFragment = new AFragment("AFragment Parameter");
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();


    }
    public void setData(String text){
        mTextViewTitle.setText(text);
    }

    @Override
    public void onClick(String text) {
        mTextViewTitle.setText(text);
    }
}
