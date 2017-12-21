package com.example.jingdong.presenter;


import com.example.jingdong.bean.RegisterBean;
import com.example.jingdong.model.RegisterModel;
import com.example.jingdong.model.imodel.IRegisterModel;
import com.example.jingdong.net.OnNetListener;
import com.example.jingdong.view.iview.IRegisterActivity;

/**
 * 作者：邱宇
 * 时间：2017-12-12 13:41
 * 类的用途：
 */

public class RegisterPrersenter {

    private final IRegisterModel iRegisterModel;
    private final IRegisterActivity iRegisterActivity;

    public RegisterPrersenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iRegisterModel = new RegisterModel();
    }

    public void register() {
        String account = iRegisterActivity.getAccount();
        String pwd = iRegisterActivity.getPwd();

        iRegisterModel.register(account, pwd, new OnNetListener<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                String code = registerBean.getCode();
                String msg = registerBean.getMsg();
                iRegisterActivity.showRegister(code, msg);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
