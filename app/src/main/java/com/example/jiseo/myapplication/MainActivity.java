package com.example.jiseo.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ListView listView;
    public static Context m_Context;
    public static ArrayList<IdPair> PairList;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_Context= this;
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        listView = findViewById(R.id.ListView);
        ListviewAdapter listviewAdapter= new ListviewAdapter();


        DataSetting();
    }
    private void DataSetting(){

        fetchData process = new fetchData();
        process.execute();
        GetParse();
    }
    public void GetParse(){

        listView = findViewById(R.id.ListView);
        ListviewAdapter listviewAdapter= new ListviewAdapter();
    /*
        for (int i=0; i<10; i++) {
            listviewAdapter.addItem(PairList.get(i).getTitle(),PairList.get(i).getTitle());
        }

  */

    listviewAdapter.addItem("1","1");

    listView.setAdapter(listviewAdapter);
    }
}
