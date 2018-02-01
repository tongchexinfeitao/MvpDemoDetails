package com.example.mvpdemotwo;

import android.app.Application;
import android.util.Log;

/**
 * Created by hasee on 2018/1/30.
 *
 * 整个程序的一个入口，他本身也是一个应用级别的上下文
 * 他的生命周期使和我们的app一样长的
 * 作用： 经常用来初始化一些第三方SDK，已经初始化一些跟app应用相关的一些数据
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        Log.e("tag", "MyApplication  " + " onCreate()  ");
    }

    public static MyApplication getAppContext() {
        return myApplication;
    }


}
