package com.example.jingdong.model;


import com.example.jingdong.bean.RegisterBean;
import com.example.jingdong.model.imodel.IRegisterModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-11 15:18
 * 类的用途：
 */

public class RegisterModel implements IRegisterModel {

    @Override
    public void register(String account, String pwd, final OnNetListener<RegisterBean> onNetListener) {

        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getRegister(account, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        onNetListener.onSuccess(registerBean);
                    }
                });
    }
}
