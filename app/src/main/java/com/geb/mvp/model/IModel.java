package com.geb.mvp.model;

/**
 * Created by guoenbo on 2018/4/26.
 */

public interface IModel{


       interface CallBackListener{
           void onError(String error);

           void onSuccess(Object repsonce);
       }


}
