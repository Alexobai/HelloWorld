package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mCheckBox4, mCheckBox5, mCheckBox6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCheckBox4 = findViewById(R.id.cb_4);
        mCheckBox5 = findViewById(R.id.cb_5);
        mCheckBox6 = findViewById(R.id.cb_6);

        mCheckBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked? "4selected":"4unselected",Toast.LENGTH_SHORT).show();
            }
        });
        mCheckBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked? "5selected":"5unselected",Toast.LENGTH_SHORT).show();
            }
        });
        mCheckBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked? "6selected":"6unselected",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
