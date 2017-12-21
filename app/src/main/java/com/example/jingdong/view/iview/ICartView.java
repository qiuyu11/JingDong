package com.example.jingdong.view.iview;


import com.example.jingdong.bean.CartBean;

import java.util.List;

/**
 * 作者：邱宇
 * 时间：2017-12-13 20:36
 * 类的用途：
 */

public interface ICartView {
    public void showList(List<CartBean.DataBean> groupList, List<List<CartBean.DataBean.ListBean>> childList);
}
