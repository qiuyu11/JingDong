package com.example.jingdong.model;


import com.example.jingdong.bean.LoginBean;
import com.example.jingdong.model.imodel.ILoginModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-09 15:54
 * 类的用途：
 */

public class LoginModel implements ILoginModel {

    @Override
    public void getLogin(String mobile, String password, final OnNetListener<LoginBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getLogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        onNetListener.onSuccess(loginBean);
                    }
                });
    }
}
