package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button mbtnTextView;
    private Button mButton;
    private Button mBtnEditText;
    private Button mRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnTextView = findViewById(R.id.btn_textview);
        mButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById((R.id.btn_edittext));
        mRadioButton = findViewById(R.id.btn_radio);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mbtnTextView.setOnClickListener(onClick);
        mButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mRadioButton.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radio:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
