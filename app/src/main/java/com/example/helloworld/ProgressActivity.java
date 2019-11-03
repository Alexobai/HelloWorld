package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mProgressBar3;
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mProgressBar3 = findViewById(R.id.pb3);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress2);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("hint");
                progressDialog.setMessage("loading");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this,"cancel");
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("hint");
                progressDialog.setMessage("loading");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                progressDialog.show();
            }
        });
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(mProgressBar3.getProgress() < 100){
                //mProgressBar3.setProgress(mProgressBar3.getProgress()+5);
                handler.postDelayed(runnable,500);
            }else{
                ToastUtil.showMsg(ProgressActivity.this,"complete");
            }

        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProgressBar3.setProgress(mProgressBar3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}
