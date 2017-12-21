package com.example.jingdong.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.example.jingdong.R;
import com.example.jingdong.fragemnt.CartFragment;
import com.example.jingdong.fragemnt.ClassFragment;
import com.example.jingdong.fragemnt.FindFragment;
import com.example.jingdong.fragemnt.HomeFragment;
import com.example.jingdong.fragemnt.MineFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton mRbHome;
    private RadioButton mRbClass;
    private RadioButton mRbFind;
    private RadioButton mRbCart;
    private RadioButton mRbMine;
    private HomeFragment homeFragment;
    private ClassFragment classFragment;
    private FindFragment findFragment;
    private CartFragment cartFragment;
    private MineFragment mineFragment;
    private RadioGroup mRg;
    private ArrayList<Fragment> fragments;
    private FrameLayout mFramelayout;
    private LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //初始化组件
        initView();
        //设置默认
        switchFragment(0);
        mRbMine.setBackgroundResource(R.drawable.ac1);
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mRbHome = (RadioButton) findViewById(R.id.rb_home);
        mRbClass = (RadioButton) findViewById(R.id.rb_class);
        mRbFind = (RadioButton) findViewById(R.id.rb_find);
        mRbCart = (RadioButton) findViewById(R.id.rb_cart);
        mRbMine = (RadioButton) findViewById(R.id.rb_mine);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mFramelayout = (FrameLayout) findViewById(R.id.framelayout);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);

        mRbHome.setOnClickListener(this);
        mRbClass.setOnClickListener(this);
        mRbFind.setOnClickListener(this);
        mRbCart.setOnClickListener(this);
        mRbMine.setOnClickListener(this);
        mRg.setOnClickListener(this);

        //创建fragment实例并把他们加入集合
        fragments = new ArrayList<>();
        addFragment();
        //设置默认被选中的RadioButton
        mRg.check(R.id.rb_home);

        //radiogroup中的radiobutton的点击事件
        mRg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        bai();
        switch (v.getId()) {
            case R.id.rb_home:
                switchFragment(0);
                mRbHome.setBackgroundResource(R.drawable.ac1);
                break;
            case R.id.rb_class:
                switchFragment(1);
                mRbClass.setBackgroundResource(R.drawable.abx);
                break;
            case R.id.rb_find:
                switchFragment(2);
                mRbFind.setBackgroundResource(R.drawable.abz);
                break;
            case R.id.rb_cart:
                switchFragment(3);
                mRbCart.setBackgroundResource(R.drawable.abv);
                break;
            case R.id.rb_mine:
                switchFragment(4);
                mRbMine.setBackgroundResource(R.drawable.ac3);
                break;
        }
    }

    /**
     * 创建fragment实例并把他们加入集合
     */

    public void addFragment() {
        fragments.add(new HomeFragment());
        fragments.add(new ClassFragment());
        fragments.add(new FindFragment());
        fragments.add(new CartFragment());
        fragments.add(new MineFragment());
    }

    /**
     * 点击切换fragment
     *
     * @param position
     */
    public void switchFragment(int position) {
        //开启事务
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        //遍历集合
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (i == position) {
                //显示fragment
                if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,显示
                    fragmentTransaction.show(fragment);
                } else {
                    //如果这个fragment没有被事务添加过,添加
                    fragmentTransaction.add(R.id.framelayout, fragment);
                }
            } else {
                //隐藏fragment
                if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,隐藏
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        //提交事务
        fragmentTransaction.commit();
    }

    private void bai() {
        mRbHome.setBackgroundResource(R.drawable.ac0);
        mRbClass.setBackgroundResource(R.drawable.abw);
        mRbFind.setBackgroundResource(R.drawable.aby);
        mRbCart.setBackgroundResource(R.drawable.abu);
        mRbMine.setBackgroundResource(R.drawable.ac2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int flag = getIntent().getIntExtra("flag", 0);
        if (flag == 5){
            bai();
            switchFragment(4);
            mRbMine.setBackgroundResource(R.drawable.ac3);
        }
    }

}
