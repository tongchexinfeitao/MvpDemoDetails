package com.example.mvpdemotwo.base;

import android.content.Context;
import android.util.Log;

import com.example.mvpdemotwo.MyApplication;

/**
 * Created by hasee on 2018/1/31.
 * 在mvp中 presenter 必须对应一个接口，来通知view层改变UI
 */

public abstract class BasePresenter<V extends IBaseView> {
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        initModle();
    }

    /**
     * 用来给子类提供一个初始化modle的地方
     */
    protected abstract void initModle();

    //如果Activity销毁了，但是presenter中还持有Activity的引用，那么就可能会造成内存泄漏
    //在activity销毁的时候，我们让presenter释放activity的引用，做到可以让GC回收
    public void onDestroy() {
        view = null;
        Log.e("tag", "BasePresenter  " + "onDestroy()  ");
    }

    //提供环境变量，如果 view.context()没有提供的话，就用application
    public Context context() {
        if (view != null && view.context() != null) {
            return view.context();
        }
        return MyApplication.getAppContext();
    }


}
