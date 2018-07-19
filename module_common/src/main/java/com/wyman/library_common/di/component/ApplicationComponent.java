package com.wyman.library_common.di.component;

import android.content.Context;

import com.wyman.library_common.di.module.ApplicationModule;
import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerApp;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/16
 * description :
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife
    Context getApplicationContext();
}
