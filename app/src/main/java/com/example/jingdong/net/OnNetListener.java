package com.example.jingdong.net;

/**
 * 作者：邱宇
 * 时间：2017-12-08 16:38
 * 类的用途：
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
