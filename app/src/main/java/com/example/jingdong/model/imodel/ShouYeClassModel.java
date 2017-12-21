package com.example.jingdong.model.imodel;



import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-16 08:51
 * 类的用途：
 */

public class ShouYeClassModel implements IShouYeClassModel {
    @Override
    public void getCatagroy(final OnNetListener<CatagoryBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getCatagory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CatagoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                        onNetListener.onSuccess(catagoryBean);
                    }
                });
    }
}
