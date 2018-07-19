package com.wyman.library_common.di.module;

import android.content.Context;


import com.wyman.library_common.base.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/18
 * description :
 */

@Module
public class PresenterModule {
    //第二种方法
//    private Context mContext;
//
//    public PresenterModule(Context mContext) {
//        this.mContext = mContext;
//    }

    /**
     * 如果需要参数：你需要传入什么参数，你就通过@Provides注解再创建一个方法提供出来这个依赖，
     * 参照 https://github.com/qingmei2/MvpArchitecture-Android/blob/2.x/module_core/src/main/java/com/qingmei2/module/di/module/HttpClientModule.java 这个类，
     * provideRetrofit()方法需要Retrofit.Builder参数，你就在下面新建一个方法并将Retrofit.Builder依赖作为返回值给它；
     * 如果你想要动态设置，就给这个Module的构造方法设置一个参数，在实例化这个Module的时候将参数传进来。
     * @param mContext
     * @return
     */

    /**
     * 第一种方法
     * @return
     */
    @Provides
    Context provideContext(){
        return BaseApplication.getAppContext();
    }
}
