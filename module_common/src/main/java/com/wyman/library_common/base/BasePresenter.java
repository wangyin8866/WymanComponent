package com.wyman.library_common.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author wyman
 * description :
 */

public  class BasePresenter<T extends BaseView> {

    private WeakReference<T> mVReference;
    public Context mContext;

    protected <T> void invoke(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).compose(getView().<T>bindToLife()).subscribe(observer);
    }

    public BasePresenter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 关联
     *
     * @param view
     */
    void attachView(T view) {
        mVReference = new WeakReference<T>(view);

    }

    /**
     * 接触关联
     */
    void detachView() {

        if (mVReference != null) {
            mVReference.clear();
            mVReference = null;
        }
    }

    public T getView() {

        return mVReference.get();
    }
}
