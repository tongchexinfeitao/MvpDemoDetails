package com.example.mvpdemotwo.home.modle;

import android.util.Log;

import com.example.mvpdemotwo.home.modle.bean.LoginBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hasee on 2018/1/30.
 */

public class LoginModle {

    //model层的login方法，对应presenter中的login方法
    public void login(String mobile, String password, final OnDataCallBack onDataCallBack) {

        //如果mvc的话，直接在这个位置去联网请求
        //如果是mvp的话，我们需要把联网的操作放到modle中

        //构建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        //通过表单的形式，构建一个RequestBody，通过添加key-value的形式，上传参数
        RequestBody requestBody = new FormBody.Builder()
                .add("source", "android")
                .add("mobile", mobile)
                .add("password", password)
                .build();

        //通过我们构造的requestBody对象，去构造一个Request
        Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(requestBody)
                .build();

        //使用okHttpClient对象执行newCall，传入一个Request，去构造一个call请求
        Call call = okHttpClient.newCall(request);

        //通过这个call请求去异步的请求登录接口
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", "============================onFailure");
                if (onDataCallBack != null) {
                    onDataCallBack.onGetDataFail(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("tag", "============================onResponse");

                if (response != null && response.body() != null) {
                    String json = response.body().string();
                    LoginBean loginBean = new Gson().fromJson(json, LoginBean.class);
                    if (onDataCallBack != null) {
                        onDataCallBack.onGetDataSuccess(loginBean);
                    }
                }else{
                    if (onDataCallBack != null) {
                        onDataCallBack.onGetDataFail(new Exception("数据返回结果为null"));
                    }
                }


            }
        });
    }


    /**
     * 是modle用来通知presenter结果的接口
     */
    public interface OnDataCallBack {
        void onGetDataSuccess(LoginBean loginBean);

        void onGetDataFail(Exception e);
    }

}
