package com.geb.mvp.presenter;

import com.geb.mvp.model.IModel;
import com.geb.mvp.model.LoginModel;
import com.geb.mvp.model.ModelImpl;
import com.geb.mvp.view.IView;
import com.geb.mvp.view.MainView;

import java.util.Map;

/**
 * Created by guoenbo on 2018/4/26.
 */

public class Presenter<T extends IView> extends IPresenter<T> {

    LoginModel iModel = new ModelImpl();

    public void Login(Map<String,Object> map){
        iModel.Login(map,new IModel.CallBackListener() {
            MainView view= (MainView) getView();
            @Override
            public void onError(String error) {
                if(view!=null){
                    view.login(error);
                }
            }

            @Override
            public void onSccess(Object repsonce) {
                if(view!=null){
                    view.login(repsonce);
                }
            }
        });
    }

    public void getNews(Map<String,Object> map){
        iModel.getNews(map,new IModel.CallBackListener() {
            MainView view= (MainView) getView();
            @Override
            public void onError(String error) {
                if(view!=null){
                    view.getNews(error);
                }
            }

            @Override
            public void onSccess(Object repsonce) {
                if(view!=null){
                    view.getNews(repsonce);
                }
            }
        });
    }
    
}
