package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-16 08:51
 * 类的用途：
 */

public interface IShouYeClassModel {
    public void getCatagroy(OnNetListener<CatagoryBean> onNetListener);
}
