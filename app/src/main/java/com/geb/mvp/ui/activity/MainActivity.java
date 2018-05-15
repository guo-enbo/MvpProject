package com.geb.mvp.ui.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.TextView;

import com.geb.mvp.R;
import com.geb.mvp.presenter.Presenter;
import com.geb.mvp.ui.activity.base.BaseActivity;
import com.geb.mvp.view.MainView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<MainView,Presenter<MainView>> implements MainView {

    private TextView tv_find;


    @Override
    public void setLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

    }

    @Override
    public void initView() {
        tv_find = findViewById(R.id.tv_find);
    }

    @Override
    public void BindEvent() {

    }

    @Override
    public void initData() {
        super.initData();
        Map<String,Object> map = new HashMap<>();
        map.put("type",0);
        presenter.Login(map);

        map.clear();

        map.put("type",1);
        presenter.getNews(map);

    }

    @Override
    public void getData(String response) {



    }



    @Override
    public Presenter<MainView> CreatPresenter() {
        return new Presenter<>();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void login(Object bean) {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void getNews(Object json) {

    }
}
