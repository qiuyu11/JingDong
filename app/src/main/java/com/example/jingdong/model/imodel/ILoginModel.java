package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.LoginBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-09 15:55
 * 类的用途：
 */

public interface ILoginModel {
    public void getLogin(String mobile, String password, OnNetListener<LoginBean> onNetListener);
}
