package com.example.jingdong.view.iview;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.HomeAdBean;

/**
 * 作者：邱宇
 * 时间：2017-12-15 14:52
 * 类的用途：
 */

public interface IShoYeView {
    //首页轮播图
    public void showData(HomeAdBean homeAdBean);

    //首页分类
    public void showCatagroy(CatagoryBean catagoryBean);
}
