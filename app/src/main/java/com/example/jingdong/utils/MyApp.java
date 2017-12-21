package com.example.jingdong.utils;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * 作者：邱宇
 * 时间：2017-12-13 10:55
 * 类的用途：
 */

public class MyApp extends Application {
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();

        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)//配置磁盘缓存
                .build();
        /**
         * 初始化Fresco
         */
        Fresco.initialize(this, config);

        sp = getSharedPreferences("user", MODE_PRIVATE);
        edit = sp.edit();
    }

}
