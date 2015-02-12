package com.example.ulugbek.myapplication;

import android.app.Application;

import com.example.ulugbek.myapplication.util.NetworkStateUtil;

/**
 * Created by Ulugbek on 09.02.2015.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkStateUtil network = new NetworkStateUtil();


    }
}
