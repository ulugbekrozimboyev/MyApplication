package com.example.ulugbek.myapplication.activities;

import android.os.Bundle;

import com.example.ulugbek.myapplication.R;

/**
 * Created by Ulugbek on 08.02.2015.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        getSupportActionBar().setSubtitle("Home");
    }


}
