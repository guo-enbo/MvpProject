package com.geb.mvp.app;

import android.app.Application;

import com.geb.mvp.net.NetProxy;
import com.geb.mvp.net.OkHttpProcessor;

/**
 * Created by guoenbo on 2018/4/27.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetProxy.init(new OkHttpProcessor());
    }



}
