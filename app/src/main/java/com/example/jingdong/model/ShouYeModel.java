package com.example.jingdong.model;


import com.example.jingdong.bean.HomeAdBean;
import com.example.jingdong.model.imodel.IShouYeModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-15 14:45
 * 类的用途：
 */

public class ShouYeModel implements IShouYeModel {
    @Override
    public void getShowYe(final OnNetListener<HomeAdBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getAD()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeAdBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(HomeAdBean homeAdBean) {
                        onNetListener.onSuccess(homeAdBean);
                    }
                });
    }
}
