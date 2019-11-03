package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopActivity extends AppCompatActivity {
    private Button mBtnPop;
    private PopupWindow mPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        Log.d("LifeCycle","Create");
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop,null);
                mPop = new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mPop.setFocusable(true);
                mPop.showAsDropDown(mBtnPop);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","destroy");
    }
}
