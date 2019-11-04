package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnEvent;
    private MyButton btnMy;
    private Button mBtnHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnEvent.setOnClickListener(new OnClick());
        btnMy = findViewById(R.id.btn_my);
        mBtnHandler = findViewById(R.id.btn_handler);
        btnMy.setOnTouchListener(new View.OnTouchListener() { //set listener is prior to any other listeners
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","OnTouchListener");
                        break;
                }
                return false;
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() { //lower prior than touchlistener
            @Override
            public void onClick(View v) {
                Log.d("Listener","OnClickListener");
            }
        });
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
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });

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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","onTouchEvent");
                break;
        }
        return false;
    }
}
