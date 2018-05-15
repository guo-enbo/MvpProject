package com.geb.mvp.ui.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geb.mvp.presenter.IPresenter;
import com.geb.mvp.view.IView;

/**
 * Created by guoenbo on 2018/5/14.
 */
public abstract class BaseFragment<V extends IView,P extends IPresenter<V>> extends Fragment {

    protected Context _context;
    protected FragmentCallBack mCallBack;
    protected P presenter;


    /**
     * Activity取Fragment所传递的值时调用的回调接口
     */
    public interface FragmentCallBack {

        /**
         * @param param Object...变参多个不固定个数不规定类型的返回结果
         * @DESC Activity中调用取出Fragment中的值
         **/
        public void setResult(Object... param);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = getActivity();

    }

    public BaseFragment() {
        super();
    }

    protected abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayout(), null);
        initView(v, savedInstanceState);
        initData();
        BindComponentEvent();
        return v;
    }

    /**
     * 初始化界面
     */
    protected abstract void initView(View v, Bundle savedInstanceState);

    /**
     * 初始化界面
     */
    protected void initData(){
        presenter = CreatPresenter();
        presenter.attach((V)this);
    };

    protected abstract P CreatPresenter();

    /**
     * 绑定控件事件
     */
    protected abstract void BindComponentEvent();

    /**
     * 声明Fragment实例，所创建的回调接口必须要在Activity中实现
     */
    @Override
    public void onAttach(Activity activity) {
        try {
            mCallBack = (FragmentCallBack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentCallBack");
        }
        super.onAttach(activity);
    }

    /**
     * 声明Fragment实例，所创建的回调接口必须要在Activity中实现
     */
    @Override
    public void onAttach(Context context) {
        try {
            mCallBack = (FragmentCallBack) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentCallBack");
        }
        super.onAttach(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK) {
            doActivityResult(requestCode, intent);
        }
    }

    /**
     * 带返回值跳转的数据的处理方法
     */
    protected abstract void doActivityResult(int requestCode, Intent intent);


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.deatch();
    }
}
