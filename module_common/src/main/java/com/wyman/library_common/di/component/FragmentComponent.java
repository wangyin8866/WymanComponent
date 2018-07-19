package com.wyman.library_common.di.component;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.wyman.library_common.di.module.FragmentModule;
import com.wyman.library_common.di.module.PresenterModule;
import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerFragment;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = {FragmentModule.class, PresenterModule.class})
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();


    Fragment getFragment();
    Activity getActivity();

}
