package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.UserInfoBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-12 21:00
 * 类的用途：
 */

public interface IUserModel {
    public void getUser(String uid, OnNetListener<UserInfoBean> onNetListener);
}
