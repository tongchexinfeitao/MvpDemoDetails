package com.example.mvpdemotwo;

import android.app.Application;

/**
 * Created by hasee on 2018/1/30.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getAppContext() {
        return myApplication;
    }

}
