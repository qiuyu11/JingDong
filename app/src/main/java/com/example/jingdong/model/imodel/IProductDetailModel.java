package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.AddCartBean;
import com.example.jingdong.bean.ProductDetailBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:13
 * 类的用途：
 */

public interface IProductDetailModel {
    public void getDetail(OnNetListener<ProductDetailBean> onNetListener, String pid);

    public void addCart(OnNetListener<AddCartBean> onNetListener, String uid, String pid);
}
