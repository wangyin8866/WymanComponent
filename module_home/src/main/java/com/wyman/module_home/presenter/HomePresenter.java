package com.wyman.module_home.presenter;

import android.content.Context;

import com.wyman.library_common.base.BasePresenter;
import com.wyman.library_common.base.BaseView;
import com.wyman.library_common.base.DataResponse;
import com.wyman.library_common.net.ProgressObserver;
import com.wyman.library_common.net.RetrofitManager;
import com.wyman.library_common.net.SubscriberOnNextListener;
import com.wyman.module_home.entity.Article;
import com.wyman.module_home.service.HomeService;

/**
 * @author wyman
 * @date 2018/7/20
 * description :
 */
public class HomePresenter extends BasePresenter<BaseView> {
    public HomePresenter(Context mContext) {
        super(mContext);
    }
    public void fetch(){
        invoke(RetrofitManager.create(HomeService.class).getHomeArticles(1),new ProgressObserver<DataResponse<Article>>(new SubscriberOnNextListener<DataResponse<Article>>() {
            @Override
            public void onNext(DataResponse<Article> articleDataResponse) {

                getView().showSuccess(articleDataResponse.toString());
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}
