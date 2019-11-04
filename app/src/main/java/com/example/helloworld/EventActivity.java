package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnEvent.setOnClickListener(new OnClick());
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            //will set the listener to the last one set
            @Override
            public void onClick(View v) {
                Log.d("anno class","click");
                ToastUtil.showMsg(EventActivity.this,"clicked");
            }
        });
//        mBtnEvent.setOnClickListener(EventActivity.this); the class itself
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this)); outer class

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "clicked");
                break;
        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    Log.d("inner class","click");
                    ToastUtil.showMsg(EventActivity.this,"clicked");
                    break;
            }
        }
    }
//    public void show(View v){
//        switch (v.getId()){
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this,"clicked");
//                break;
//        }
//    }
}
