package com.wyman.library_common.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;


import com.wyman.library_common.di.scope.ContextLife;
import com.wyman.library_common.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */

@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment mFragment) {
        this.mFragment = mFragment;
    }
    @PerFragment
    @ContextLife("Activity")
    @Provides
     Context provideActivityContext(){
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    Activity provideActivity(){
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
     Fragment provideFragment(){
        return mFragment;
    }
}
