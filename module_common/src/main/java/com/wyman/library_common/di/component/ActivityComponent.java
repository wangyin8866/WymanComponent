package com.wyman.library_common.di.component;

import android.app.Activity;
import android.content.Context;

import com.wyman.library_common.di.module.ActivityModule;
import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerActivity;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class})
public interface ActivityComponent {


    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

}
