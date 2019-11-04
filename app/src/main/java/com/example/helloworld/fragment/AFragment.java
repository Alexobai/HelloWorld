package com.example.helloworld.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloworld.R;

import org.w3c.dom.Text;

public class AFragment extends Fragment {
    private TextView mTextViewTitle;
    private Button mBtnChange,mBtnReset,mBtnMsg;
    private BFragment bFragment;
    private IOnMessageClick listener;


    public AFragment(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        setArguments(bundle);
    }


    public interface  IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (IOnMessageClick) context;
        }catch(ClassCastException e){
            throw new ClassCastException("Activity realization failed ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment","onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextViewTitle = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnMsg = view.findViewById(R.id.btn_msg);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewTitle.setText("new Text");
            }
        });
        mBtnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ((ContainerActivity) getActivity()).setData("hello");
                listener.onClick("Hi");
            }
        });
        if (getArguments() != null) {
            mTextViewTitle.setText(getArguments().getString("title"));
        }
    }


}

