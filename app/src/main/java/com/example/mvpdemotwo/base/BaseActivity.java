package com.example.mvpdemotwo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by hasee on 2018/1/31.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    /**
     * 在mvp的框架中，每一个页面都有一个自己的presenter，那么就可以把这个
     * presenter抽象到基类中，这个抽象的presenter，并不是指具体某个presenter，
     * 这个presenter的类型不能固定，需要由子类Activity来决定，
     * 所以在基类中这个不确定的Presenter
     * 我们用泛型< P> 来代替
     * 例如： LoginActivity对应的是LoginPresenter
     */
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("tag", "BaseActivity  " + " onCreate()  ");

        setContentView(provideLayoutId());
        initView();
        initListener();
        presenter = providePresenter();
        initData();
    }

    protected abstract P providePresenter();

    /**
     * 初始化监听
     */
    protected void initListener() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }


 /**
     * 初始化视图
     */
    protected void initView() {
    }
    /**
     * 设置布局ID
     */
    public abstract int provideLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        Log.e("tag", "BaseActivity  " + " onDestroy()  ");
    }
}
