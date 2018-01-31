package com.example.mvpdemotwo.home.view.Iview;

/**
 * Created by hasee on 2018/1/30.
 */

import com.example.mvpdemotwo.base.IBaseView;
import com.example.mvpdemotwo.home.modle.bean.LoginBean;

/**
 * 是presenter用来通知activity结果的接口
 */
public interface ILoginView extends IBaseView {
    void loginSuccess(LoginBean loginBean);

    void loginFail(Exception e);
}
