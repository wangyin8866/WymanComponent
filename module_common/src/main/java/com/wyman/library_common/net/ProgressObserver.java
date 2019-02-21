package com.wyman.library_common.net;


import android.content.Context;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author wyman
 *  2018/4/12
 * description :
 */

public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {
    private Disposable disposable;
    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Context context;

    public ProgressObserver(SubscriberOnNextListener<T> mSubscriberOnNextListener, Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onCancelProgress() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        if (!NetworkUtils.isConnected()) {
            Toast.makeText(context, "当前网络不可用，请检查网络情况！", Toast.LENGTH_SHORT).show();
            // 一定好主动调用下面这一句
            onComplete();
            return;
        }
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);

    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e("onError", e.getMessage());
        dismissProgressDialog();
        mSubscriberOnNextListener.onError(e);
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }
}
