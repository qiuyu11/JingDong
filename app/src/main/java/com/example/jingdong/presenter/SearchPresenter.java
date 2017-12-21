package com.example.jingdong.presenter;


import com.example.jingdong.bean.SearchBean;
import com.example.jingdong.model.SearchModel;
import com.example.jingdong.model.imodel.ISearchModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.ISearchActivity;

/**
 * 作者：邱宇
 * 时间：2017-12-16 11:34
 * 类的用途：
 */

public class SearchPresenter {

    private final ISearchModel iSearchModel;
    private final ISearchActivity iSearchActivity;

    public SearchPresenter(ISearchActivity iSearchActivity) {
        this.iSearchActivity = iSearchActivity;
        iSearchModel = new SearchModel();
    }

    public void getSearch(String key) {
        iSearchModel.getSearch(new OnNetListener<SearchBean>() {
            @Override
            public void onSuccess(SearchBean searchBean) {
                iSearchActivity.show(searchBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, key);
    }
}
