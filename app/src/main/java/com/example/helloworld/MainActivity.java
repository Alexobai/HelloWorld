package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.datastorage.DataStorageActivity;
import com.example.helloworld.fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnFragment,mBtnEvent,mBtnDataStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnEvent.setOnClickListener(onClick);
        mBtnDataStorage = findViewById(R.id.btn_data);
        mBtnDataStorage.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch(v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
