package com.wyman.library_common.di.module;

import android.app.Activity;
import android.content.Context;


import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @PerActivity
    @ContextLife("Activity")
    @Provides
    public Context provideActivityContext() {
        return mActivity;
    }

    @PerActivity
    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}
