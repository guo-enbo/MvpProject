package com.geb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.geb.mvp.presenter.Presenter;
import com.geb.mvp.ui.fragment.base.BaseFragment;
import com.geb.mvp.view.MainView;

/**
 * Created by guoenbo on 2018/5/14.
 */

public class MainFragment extends BaseFragment<MainView,Presenter<MainView>> implements MainView{

    @Override
    protected Presenter<MainView> CreatPresenter() {
        return new Presenter<>();
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initView(View v, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void BindComponentEvent() {

    }

    @Override
    public void getData(String response) {

    }

    @Override
    public void login(Object json) {

    }

    @Override
    public void getNews(Object json) {

    }

    @Override
    protected void doActivityResult(int requestCode, Intent intent) {

    }
}
