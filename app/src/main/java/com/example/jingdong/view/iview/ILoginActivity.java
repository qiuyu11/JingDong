package com.example.jingdong.view.iview;


import com.example.jingdong.bean.LoginBean;

/**
 * 作者：邱宇
 * 时间：2017-12-09 16:06
 * 类的用途：
 */

public interface ILoginActivity {
    public String getAccount();

    public String getpwd();

    public void showLogin(LoginBean loginBean, String code, String msg);
}
