package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView api;
    static RelativeLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api=(TextView)findViewById(R.id.api);
        mainLayout=(RelativeLayout)findViewById(R.id.mainLayout);

        FetchData fetchData=new FetchData();
        fetchData.execute();
    }
}
