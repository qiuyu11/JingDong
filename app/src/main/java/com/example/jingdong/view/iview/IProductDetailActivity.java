package com.example.jingdong.view.iview;


import com.example.jingdong.bean.AddCartBean;
import com.example.jingdong.bean.ProductDetailBean;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:23
 * 类的用途：
 */

public interface IProductDetailActivity {
    public void showDetail(ProductDetailBean detailBean);

    public void addCart(AddCartBean addCartBean);
}
