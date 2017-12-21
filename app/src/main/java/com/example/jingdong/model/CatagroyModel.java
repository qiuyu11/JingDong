package com.example.jingdong.model;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.ProductCatagoryBean;
import com.example.jingdong.model.imodel.ICatagroyModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-13 09:16
 * 类的用途：
 */

public class CatagroyModel implements ICatagroyModel {
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

                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                        onNetListener.onSuccess(catagoryBean);
                    }
                });
    }

    @Override
    public void getProductCatagory(String cid, final OnNetListener<ProductCatagoryBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getProductCatagory(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductCatagoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean productCatagoryBean) {
                        onNetListener.onSuccess(productCatagoryBean);
                    }
                });
    }
}
