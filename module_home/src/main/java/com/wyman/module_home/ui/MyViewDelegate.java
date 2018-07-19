package com.wyman.module_home.ui;

import android.support.annotation.Keep;

import com.wyman.library_common.base.IViewDelegate;

import me.yokeyword.fragmentation.ISupportFragment;


/**
 * <p>类说明</p>
 *
 * @author 张华洋 2018/1/4 22:16
 * @version V2.8.3
 * @name MyViewDelegate
 */
@Keep
public class MyViewDelegate implements IViewDelegate {

    @Override
    public ISupportFragment getFragment(String name) {
        return HomeFragment.newInstance();
    }


}
