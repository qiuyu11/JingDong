package com.example.jingdong.presenter;


import com.example.jingdong.bean.ZiProductBean;
import com.example.jingdong.model.ZiProductModel;
import com.example.jingdong.model.imodel.IZiProductModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.IZiProductActivity;

/**
 * 作者：邱宇
 * 时间：2017-12-17 20:09
 * 类的用途：
 */

public class ZiProductPresenter {

    private final IZiProductModel iZiProductModel;
    private final IZiProductActivity iZiProductActivity;

    public ZiProductPresenter(IZiProductActivity iZiProductActivity) {
        this.iZiProductActivity = iZiProductActivity;
        iZiProductModel = new ZiProductModel();
    }

    public void getZiProduct(String cid) {
        iZiProductModel.getZiProduct(new OnNetListener<ZiProductBean>() {
            @Override
            public void onSuccess(ZiProductBean productBean) {
                iZiProductActivity.showZiProduct(productBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, cid);
    }
}
