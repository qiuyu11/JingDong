package com.example.jingdong.model;


import com.example.jingdong.bean.AddCartBean;
import com.example.jingdong.bean.ProductDetailBean;
import com.example.jingdong.model.imodel.IProductDetailModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:10
 * 类的用途：
 */

public class ProductDetailModel implements IProductDetailModel {

    @Override
    public void getDetail(final OnNetListener<ProductDetailBean> onNetListener, String pid) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getDetail(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(ProductDetailBean productDetailBean) {
                        onNetListener.onSuccess(productDetailBean);
                    }
                });
    }

    @Override
    public void addCart(final OnNetListener<AddCartBean> onNetListener, String uid, String pid) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.addCart(uid,pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddCartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(AddCartBean addCartBean) {
                        onNetListener.onSuccess(addCartBean);
                    }
                });
    }


}
