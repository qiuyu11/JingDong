package com.example.jingdong.model;


import com.example.jingdong.bean.UserInfoBean;
import com.example.jingdong.model.imodel.IUserModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-12 20:59
 * 类的用途：
 */

public class UserModel implements IUserModel {

    @Override
    public void getUser(String uid, final OnNetListener<UserInfoBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getUserInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        onNetListener.onSuccess(userInfoBean);
                    }
                });
    }
}
