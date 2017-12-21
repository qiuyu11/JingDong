package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.RegisterBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-11 15:23
 * 类的用途：
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetListener<RegisterBean> onNetListener);
}
