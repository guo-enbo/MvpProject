package com.geb.mvp.net;

import java.util.HashMap;
import java.util.Map;

public class NetProxy implements HttpProcessor{

    private static NetProxy _instance;
    private static HttpProcessor mHttpProcessor = null;
    private Map<String, Object> params;

    public static void init(HttpProcessor httpProcessor){
        mHttpProcessor = httpProcessor;
    }

    private NetProxy(){
        params = new HashMap<>();
    }

    public static NetProxy obtain(){
        synchronized (NetProxy.class){
            if(null == _instance){
                _instance = new NetProxy();
            }
        }
        return _instance;
    }


    @Override
    public void get(String url, Map<String, Object> params, NetCallback callback) {
        mHttpProcessor.get(url, params, callback);
    }

    @Override
    public void post(String url, Map<String, Object> params, NetCallback callback) {
        mHttpProcessor.post(url, params, callback);
    }




}
