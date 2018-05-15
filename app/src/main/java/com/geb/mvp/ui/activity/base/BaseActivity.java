package com.geb.mvp.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geb.mvp.presenter.IPresenter;
import com.geb.mvp.view.IView;

/**
 * Created by guoenbo on 2018/4/26.
 */

public abstract class BaseActivity<V extends IView,P extends IPresenter<V>> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(savedInstanceState);
        initView();
        initData();
        BindEvent();


    }

    public abstract void setLayout(@Nullable Bundle savedInstanceState);

    public abstract void initView();

    public abstract void BindEvent();

    public void initData(){
        presenter = CreatPresenter();
        presenter.attach((V)this);
    };

    public abstract P CreatPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatch();
    }
}
