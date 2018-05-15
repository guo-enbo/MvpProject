package com.geb.mvp.model;

import com.geb.mvp.bean.BannerBean;
import com.geb.mvp.net.HttpCallback;
import com.geb.mvp.net.NetProxy;

import java.util.Map;

/**
 * Created by guoenbo on 2018/4/26.
 */

public class ModelImpl implements LoginModel {

    @Override
    public void Login(Map<String, Object> map, final CallBackListener callBackListener) {
        NetProxy.obtain().post("http://service.qiji99.cn/webapi/getadv.ashx", map, new HttpCallback<BannerBean>() {

            @Override
            public void onFailure(int statusCode, String errorMsg) {

            }

            @Override
            public void onSuccess(int statusCode, BannerBean bannerBean) {
                callBackListener.onSccess(bannerBean);
            }

            @Override
            public void onFailure(Exception e, String errorMsg) {

            }
        });
    }


    @Override
    public void getNews(Map<String, Object> map, final CallBackListener callBackListener) {
        NetProxy.obtain().post("http://service.qiji99.cn/webapi/getadv.ashx", map, new HttpCallback<BannerBean>() {

            @Override
            public void onFailure(int statusCode, String errorMsg) {

            }

            @Override
            public void onSuccess(int statusCode, BannerBean bannerBean) {
                callBackListener.onSccess(bannerBean);
            }

            @Override
            public void onFailure(Exception e, String errorMsg) {

            }
        });
    }
}
