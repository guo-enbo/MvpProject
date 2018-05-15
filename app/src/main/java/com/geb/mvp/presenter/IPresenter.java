package com.geb.mvp.presenter;

import com.geb.mvp.view.IView;

import java.lang.ref.WeakReference;

/**
 * Created by guoenbo on 2018/4/26.
 */

public abstract class IPresenter<V extends IView>{

    //弱引用便于销毁对象，避免OOM
    protected WeakReference<V> weakReference;

    public void attach(V view)
    {
        weakReference=new WeakReference<V>(view);
    }

    public void deatch()
    {
        if(weakReference!=null)
        {
            weakReference.clear();
        }
    }

    protected V getView(){
        return weakReference!=null ? weakReference.get() : null;
    }
}

