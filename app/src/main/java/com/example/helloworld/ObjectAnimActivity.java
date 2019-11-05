package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        mTextView = findViewById(R.id.tv);
        //mTextView.animate().translationYBy(500).setDuration(2000).start();
        //mTextView.animate().translationY(500).setDuration(2000).start();
        //mTextView.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //actual number
//                Log.d("anime",animation.getAnimatedValue()+"");
//                //process number 0-1
//                Log.d("anime",animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView,"translationY",0,500,200,300);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}
