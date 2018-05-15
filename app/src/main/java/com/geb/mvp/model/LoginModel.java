package com.geb.mvp.model;

import java.util.Map;

/**
 * Created by guoenbo on 2018/4/27.
 */

public interface LoginModel extends IModel {
    void Login(Map<String,Object> map, CallBackListener callBackListener);

    void getNews(Map<String,Object> map, CallBackListener callBackListener);

}
