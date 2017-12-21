package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.HomeAdBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-15 14:46
 * 类的用途：
 */

public interface IShouYeModel {
    public void getShowYe(OnNetListener<HomeAdBean> onNetListener);
}
