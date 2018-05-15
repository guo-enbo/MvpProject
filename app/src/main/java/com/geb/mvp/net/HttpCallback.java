package com.geb.mvp.net;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class HttpCallback<Result> implements NetCallback {

    public abstract void onSuccess(int statusCode, Result result);


    @Override
    public void onSuccess(int statusCode, String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result, clz);
        onSuccess(statusCode, objResult);
    }

    public static Class<?> analysisClassInfo(Object object){
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>) params[0];

    }
}
