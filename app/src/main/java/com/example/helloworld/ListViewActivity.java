package com.example.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
//No Helloworld dashboard is because of the Activity class extention
public class ListViewActivity extends Activity {
    private ListView mListView1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView1 = findViewById(R.id.lv_1);
        mListView1.setAdapter(new MyListViewAdapter(ListViewActivity.this));
        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"click" + position, Toast.LENGTH_SHORT ).show();
            }
        });
        mListView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"long click" + position, Toast.LENGTH_SHORT ).show();
                return true; //return false make it continue to listen
            }
        });
    }
}
