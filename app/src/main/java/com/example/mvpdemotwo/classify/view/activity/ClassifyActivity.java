package com.example.mvpdemotwo.classify.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpdemotwo.R;
import com.example.mvpdemotwo.base.BaseActivity;
import com.example.mvpdemotwo.classify.presenter.ClassifyPresenter;
import com.example.mvpdemotwo.classify.view.IClassifyView;

public class ClassifyActivity extends BaseActivity<ClassifyPresenter> implements IClassifyView {


    @Override
    protected ClassifyPresenter providePresenter() {
        return new ClassifyPresenter(this);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_classify2;
    }

    @Override
    public Context context() {
        return this;
    }
}
