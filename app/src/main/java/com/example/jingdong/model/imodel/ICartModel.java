package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.CartBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-13 20:31
 * 类的用途：
 */

public interface ICartModel {
    public void getGoods(String uid, String token, OnNetListener<CartBean> onNetListener);
}
