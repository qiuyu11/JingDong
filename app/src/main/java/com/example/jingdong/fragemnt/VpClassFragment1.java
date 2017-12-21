package com.example.jingdong.fragemnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jingdong.R;
import com.example.jingdong.adapter.GridShouAdapter;
import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.HomeAdBean;
import com.example.jingdong.presenter.ShouYePresenter;
import com.example.jingdong.view.iview.IShoYeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：邱宇
 * 时间：2017-12-16 09:46
 * 类的用途：
 */

public class VpClassFragment1 extends Fragment implements IShoYeView {
    private View view;
    private RecyclerView mSyRlv1;
    private List<CatagoryBean.DataBean> list2 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.shouye_catagro_vp1, null);
        ShouYePresenter shouYePresenter = new ShouYePresenter(this);
        initView(view);
        shouYePresenter.getCatagroy();
        return view;
    }

    private void initView(View view) {
        mSyRlv1 = (RecyclerView) view.findViewById(R.id.sy_rlv1);
    }

    @Override
    public void showData(HomeAdBean homeAdBean) {

    }

    @Override
    public void showCatagroy(CatagoryBean catagoryBean) {
        //创建网格布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        //给RecyClerView 添加设置好的布局样式
        mSyRlv1.setLayoutManager(gridLayoutManager);

        List<CatagoryBean.DataBean> data = catagoryBean.getData();
        for (int i = 0; i < 10; i++) {
            CatagoryBean.DataBean dataBean = data.get(i);
            list2.add(dataBean);
        }
        //创建适配器
        GridShouAdapter gridShouAdapter = new GridShouAdapter(getActivity(), list2);
        mSyRlv1.setAdapter(gridShouAdapter);
    }
}
