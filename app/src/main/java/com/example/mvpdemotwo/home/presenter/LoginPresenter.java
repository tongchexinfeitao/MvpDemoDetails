package com.example.mvpdemotwo.home.presenter;

import android.util.Log;

import com.example.mvpdemotwo.base.BasePresenter;
import com.example.mvpdemotwo.home.modle.LoginModle;
import com.example.mvpdemotwo.home.modle.bean.LoginBean;
import com.example.mvpdemotwo.home.view.Iview.ILoginView;

/**
 * Created by hasee on 2018/1/30.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private LoginModle loginModle;

    public LoginPresenter(ILoginView view) {
        super(view);
    }


    @Override
    protected void initModle() {
        Log.e("tag", "LoginPresenter  " + "initModle()  ");
        loginModle = new LoginModle();
    }

    //presenter中间层的login方法，对应view中的login方法
    public void login(String mobile, String password) {
        Log.e("tag", "LoginPresenter  " + "login()  ");
        //通过给modle传递一个数据回调的接口，我们可以拿到登录的结果
        loginModle.login(mobile, password, new LoginModle.OnDataCallBack() {
            @Override
            public void onGetDataSuccess(LoginBean loginBean) {
                //拿到登录的成功之后，我们需要通知一下activity
                if (view != null) {
                    view.loginSuccess(loginBean);
                }
            }

            @Override
            public void onGetDataFail(Exception e) {
                Log.e("tag", "LoginPresenter  " + "onGetDataFail()  ");
                //拿到登录的失败之后，我们需要通知一下activity
                if (view != null) {
                    view.loginFail(e);
                }
            }
        });
    }



}
