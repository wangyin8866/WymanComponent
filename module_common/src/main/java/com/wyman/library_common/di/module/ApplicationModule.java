package com.wyman.library_common.di.module;

import android.content.Context;


import com.wyman.library_common.base.BaseApplication;
import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Module
public class ApplicationModule {
    private BaseApplication mApplication;

    public ApplicationModule(BaseApplication mApplication) {
        this.mApplication = mApplication;
    }
    @PerApp
    @Provides
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
