package com.wyman.library_common.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wyman.library_common.BuildConfig;
import com.wyman.library_common.utils.LogUtils;
import com.wyman.library_common.utils.Utils;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author wyman
 * @date 2018/7/11
 * description :
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 */
public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fragmentation.builder().stackViewMode(Fragmentation.BUBBLE).debug(BuildConfig.DEBUG).install();

        initARouter();
        Utils.init(this);
        //是否打印日志
        LogUtils.isDebug = BuildConfig.DEBUG;
        com.blankj.utilcode.util.Utils.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }


    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}
