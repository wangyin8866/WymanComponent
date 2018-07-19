package com.wyman.library_common.net;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);

}