package com.example.jingdong.presenter;


import com.example.jingdong.bean.AddCartBean;
import com.example.jingdong.bean.ProductDetailBean;
import com.example.jingdong.model.ProductDetailModel;
import com.example.jingdong.model.imodel.IProductDetailModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.IProductDetailActivity;

/**
 * 作者：邱宇
 * 时间：2017-12-17 19:22
 * 类的用途：
 */

public class ProductDetailPresenter {

    private final IProductDetailModel iProductDetailModel;
    private final IProductDetailActivity iProductDetailActivity;

    public ProductDetailPresenter(IProductDetailActivity iProductDetailActivity) {
        this.iProductDetailActivity = iProductDetailActivity;
        iProductDetailModel = new ProductDetailModel();
    }

    public void getDetail(String pid) {
        iProductDetailModel.getDetail(new OnNetListener<ProductDetailBean>() {
            @Override
            public void onSuccess(ProductDetailBean detailBean) {
                iProductDetailActivity.showDetail(detailBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, pid);
    }

    public void addCart(String uid, String pid) {
        iProductDetailModel.addCart(new OnNetListener<AddCartBean>() {
            @Override
            public void onSuccess(AddCartBean addCartBean) {
                iProductDetailActivity.addCart(addCartBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, uid, pid);
    }
}
