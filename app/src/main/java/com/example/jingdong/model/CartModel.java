package com.example.jingdong.model;


import com.example.jingdong.bean.CartBean;
import com.example.jingdong.model.imodel.ICartModel;
import com.example.jingdong.net.HttpUtils;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：邱宇
 * 时间：2017-12-13 20:31
 * 类的用途：
 */

public class CartModel implements ICartModel {
    @Override
    public void getGoods(String uid, String token,final OnNetListener<CartBean> onNetListener) {
        HttpUtils httpUtils = RetrofitHelper.getHttpUtils();
        httpUtils.getGoods(uid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        onNetListener.onSuccess(cartBean);
                    }
                });
    }
}
