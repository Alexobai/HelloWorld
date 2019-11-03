package com.example.helloworld;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTextViewTitle, mTextViewCancel, mTextViewConfirm, mTextViewMsg;



    private String title, msg, cancel, confirm;

    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeId) {
        super(context, themeId);
    }
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int)(size.x * 0.8);
        getWindow().setAttributes(p);//set 80% of screen

        mTextViewTitle = findViewById(R.id.tv_title);
        mTextViewMsg = findViewById(R.id.tv_msg);
        mTextViewCancel = findViewById(R.id.tv_cancel);
        mTextViewConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTextViewTitle.setText(title);
        }
        if(!TextUtils.isEmpty(msg)){
            mTextViewMsg.setText(msg);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTextViewMsg.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTextViewMsg.setText(confirm);
        }
        mTextViewCancel.setOnClickListener(this);
        mTextViewConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                if(cancelListener != null){
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if(confirmListener != null){
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }
    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
