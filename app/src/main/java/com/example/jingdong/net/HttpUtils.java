package com.example.jingdong.net;



import com.example.jingdong.bean.AddCartBean;
import com.example.jingdong.bean.CartBean;
import com.example.jingdong.bean.CatagoryBean;
import com.example.jingdong.bean.HomeAdBean;
import com.example.jingdong.bean.LoginBean;
import com.example.jingdong.bean.ProductCatagoryBean;
import com.example.jingdong.bean.ProductDetailBean;
import com.example.jingdong.bean.RegisterBean;
import com.example.jingdong.bean.SearchBean;
import com.example.jingdong.bean.UserInfoBean;
import com.example.jingdong.bean.ZiProductBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：邱宇
 * 时间：2017-12-09 14:52
 * 类的用途：
 */

public interface HttpUtils {
    //登录
    @GET(API.LOGIN)
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String password);

    //注册
    @GET(API.REGISTER)
    Observable<RegisterBean> getRegister(@Query("mobile") String mobile, @Query("password") String password);

    //获取用户信息
    @GET(API.USERINFO)
    Observable<UserInfoBean> getUserInfo(@Query("uid") String uid);

    //首页广播
    @GET(API.HOMEAD)
    Observable<HomeAdBean> getAD();

    //搜索
    @GET(API.SEARCH)
    Observable<SearchBean> getSearch(@Query("keywords") String key);

    //商品分类
    @GET(API.CLASS)
    Observable<CatagoryBean> getCatagory();

    //商品子分类
    @GET(API.PRODUCT_CATAGORY)
    Observable<ProductCatagoryBean> getProductCatagory(@Query("cid") String cid);

    //子分类下的商品列表
    @GET(API.ZIPRODUCT)
    Observable<ZiProductBean> getZiProduct(@Query("pscid") String pscid);

    //商品详情
    @GET(API.PRODUCTDETAIL)
    Observable<ProductDetailBean> getDetail(@Query("pid") String pid);

    //添加购物车
    @GET(API.ADDCART)
    Observable<AddCartBean> addCart(@Query("uid") String uid, @Query("pid") String pid);

    //查询购物车
    @GET(API.GETCARTS)
    Observable<CartBean> getGoods(@Query("uid") String uid, @Query("token") String token);
}
