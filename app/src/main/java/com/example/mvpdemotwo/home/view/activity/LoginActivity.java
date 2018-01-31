package com.example.mvpdemotwo.home.view.activity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.mvpdemotwo.R;
import com.example.mvpdemotwo.base.BaseActivity;
import com.example.mvpdemotwo.home.modle.bean.LoginBean;
import com.example.mvpdemotwo.home.presenter.LoginPresenter;
import com.example.mvpdemotwo.home.view.Iview.ILoginView;

/**
 * view层，视图层
 * <p>
 * 子类在继承父类的过程中，只需要指定泛型的类型就可以 ，如：
 * LoginActivity extends BaseActivity<LoginPresenter>
 * 这样相当于在LoginActivity 中这个P 就代表的是LoginPresenter
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {

    public static final String mobile = "15501186623";
    public static final String password = "123456";

    //点击事件，点击去登录
    public void login(View view) {
        //我们去调用Presenter中的登录方法
        presenter.login(mobile, password);
    }


    /**
     * 登录成功
     *
     * @param loginBean
     */
    @Override
    public void loginSuccess(final LoginBean loginBean) {

        //okhttp的回调是在子线程的
        //切到主线程，更新UI
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //登录成功
                Toast.makeText(LoginActivity.this, "登录成功" + loginBean.getData().getMobile(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 登录失败
     *
     * @param e
     */
    @Override
    public void loginFail(final Exception e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //登录失败
                Toast.makeText(LoginActivity.this, "登录失败 失败的原因是 :" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


}
