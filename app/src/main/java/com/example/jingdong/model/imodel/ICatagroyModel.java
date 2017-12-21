package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.ProductCatagoryBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-13 09:16
 * 类的用途：
 */

public interface ICatagroyModel {
    public void getCatagroy(OnNetListener<CatagoryBean> onNetListener);
    public void getProductCatagory(String cid, OnNetListener<ProductCatagoryBean> onNetListener);
}
