package com.geb.mvp.net;

public interface NetCallback {

     void onSuccess(int statusCode, String result);

     void onFailure(int statusCode, String errorMsg);

    /**
     * 请求失败
     * @param e 异常
     * @param errorMsg 异常提示信息
     * */
     void onFailure(Exception e, String errorMsg);

}
