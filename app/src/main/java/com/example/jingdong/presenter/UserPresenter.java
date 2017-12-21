package com.example.jingdong.presenter;


import com.example.jingdong.bean.UserInfoBean;
import com.example.jingdong.model.UserModel;
import com.example.jingdong.model.imodel.IUserModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.IUserView;

/**
 * 作者：邱宇
 * 时间：2017-12-12 21:04
 * 类的用途：
 */

public class UserPresenter {

    private final IUserModel iUserModel;
    private final IUserView iUserView;

    public UserPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        iUserModel = new UserModel();
    }

    public void getUser(String uid){
        iUserModel.getUser(uid, new OnNetListener<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                iUserView.showUserInfo(userInfoBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
