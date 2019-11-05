package com.example.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mBtnSave,mBtnShow;
    private TextView mTextView;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEditText = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTextView = findViewById(R.id.tv_show);

        mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();



        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEditText.getText().toString());
                mEditor.apply();
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mSharedPreferences.getString("name",""));
            }
        });
    }
}
