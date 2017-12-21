package com.example.jingdong.view.iview;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.ProductCatagoryBean;

import java.util.List;

/**
 * 作者：邱宇
 * 时间：2017-12-13 09:18
 * 类的用途：
 */

public interface IClassView {
    public void showData(List<CatagoryBean.DataBean> list);
    public void showElvData(List<ProductCatagoryBean.DataBean> groupList, List<List<ProductCatagoryBean.DataBean.ListBean>> childList);
}
