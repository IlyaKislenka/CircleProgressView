package com.example.i_kislenko.circleprogressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((CircleProgressLayout) findViewById(R.id.circle_layout)).setPercentage(0.35f);
        ((CircleProgressLayout) findViewById(R.id.less_circle_layout)).setPercentage(0.85f);
        ((CircleProgressLayout) findViewById(R.id.less_than_circle_layout)).setPercentage(1.0f);
    }
}
