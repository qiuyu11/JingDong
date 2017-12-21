package com.example.jingdong.model;

import com.example.jingdong.bean.ZiProductBean;
import com.example.jingdong.model.imodel.IZiProductModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:59
 * 类的用途：
 */

public class ZiProductModel implements IZiProductModel {

    @Override
    public void getZiProduct(final OnNetListener<ZiProductBean> onNetListener, String pid) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getZiProduct(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZiProductBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(ZiProductBean ziProductBean) {
                        onNetListener.onSuccess(ziProductBean);
                    }
                });
    }
}
