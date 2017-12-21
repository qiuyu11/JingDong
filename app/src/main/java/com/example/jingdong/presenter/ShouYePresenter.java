package com.example.jingdong.presenter;


import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.HomeAdBean;
import com.example.jingdong.model.ShouYeModel;
import com.example.jingdong.model.imodel.IShouYeClassModel;
import com.example.jingdong.model.imodel.IShouYeModel;
import com.example.jingdong.model.imodel.ShouYeClassModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.IShoYeView;

/**
 * 作者：邱宇
 * 时间：2017-12-15 14:54
 * 类的用途：
 */

public class ShouYePresenter {
    private static IShouYeModel iShouYeModel;
    private final IShoYeView iShoYeView;
    private final IShouYeClassModel iShouYeClassModel;

    public ShouYePresenter(IShoYeView iShoYeView) {
        this.iShoYeView = iShoYeView;
        iShouYeModel = new ShouYeModel();
        iShouYeClassModel = new ShouYeClassModel();
    }

    public void getShowYe(){
        iShouYeModel.getShowYe(new OnNetListener<HomeAdBean>() {
            @Override
            public void onSuccess(HomeAdBean homeAdBean) {
                iShoYeView.showData(homeAdBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public void getCatagroy(){
        iShouYeClassModel.getCatagroy(new OnNetListener<CatagoryBean>() {
            @Override
            public void onSuccess(CatagoryBean catagoryBean) {
                iShoYeView.showCatagroy(catagoryBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
