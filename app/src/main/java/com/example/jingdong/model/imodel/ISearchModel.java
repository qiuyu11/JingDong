package com.example.jingdong.model.imodel;


import com.example.jingdong.bean.SearchBean;
import com.example.jingdong.net.OnNetListener;

/**
 * 作者：邱宇
 * 时间：2017-12-16 11:31
 * 类的用途：
 */

public interface ISearchModel {
    public void getSearch(OnNetListener<SearchBean> onNetListener, String key);
}
