package com.example.jingdong.fragemnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.jingdong.R;
import com.example.jingdong.presenter.UserPresenter;
import com.example.jingdong.utils.MyApp;
import com.example.jingdong.view.LoginActivity;
import com.example.jingdong.view.MyActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Random;

/**
 * 作者：邱宇
 * 时间：2017-12-05 09:55
 * 类的用途：
 */

public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 登录/注册>
     */
    private TextView mMyLogin;
    private UserPresenter userPresenter;
    private String uid;
    private ImageView mMyImg;
    private SimpleDraweeView mMyXimg;
    /**
     * sss
     */
    private TextView mMyNickname;
    private String nickname;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        initView(view);
        into();
        info();
        return view;
    }

    private void initView(View view) {
        mMyLogin = (TextView) view.findViewById(R.id.my_login);
        mMyLogin.setOnClickListener(this);
        mMyImg = (ImageView) view.findViewById(R.id.my_img);
        mMyXimg = (SimpleDraweeView) view.findViewById(R.id.my_ximg);
        mMyNickname = (TextView) view.findViewById(R.id.my_nickname);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void into() {
        boolean isLogin = MyApp.sp.getBoolean("flag", false);
        if (isLogin) {
            Random random = new Random();
            int i = random.nextInt(100);
            nickname = MyApp.sp.getString("name", "");
            mMyNickname.setText("ZZ_" + i);
            mMyXimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    public void info() {
        boolean isLogin = MyApp.sp.getBoolean("flag", false);

        Log.e("-----", isLogin + "");
        if (isLogin) {
            mMyLogin.setVisibility(View.GONE);
            mMyImg.setVisibility(View.GONE);
            mMyNickname.setVisibility(View.VISIBLE);
            mMyXimg.setVisibility(View.VISIBLE);
            mMyNickname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MyActivity.class);
                    intent.putExtra("name", nickname);
                    startActivity(intent);
                }
            });

        } else {
            mMyLogin.setVisibility(View.VISIBLE);
            mMyImg.setVisibility(View.VISIBLE);
            mMyNickname.setVisibility(View.GONE);
            mMyXimg.setVisibility(View.GONE);
            mMyLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            mMyImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        into();
        info();
    }

}
