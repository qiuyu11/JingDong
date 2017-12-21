package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.ZiProductBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:59
 * 类的用途：
 */

public interface IZiProductModel {
    public void getZiProduct(OnNetListener<ZiProductBean> onNetListener, String pid);
}
