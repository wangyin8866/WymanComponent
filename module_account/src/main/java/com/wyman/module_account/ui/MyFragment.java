package com.wyman.module_account.ui;

import android.view.View;

import com.wyman.library_common.base.BaseFragment;
import com.wyman.module_account.R;


/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */

public class MyFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_main;
    }

    @Override
    protected void initInjector() {
    }


    public static MyFragment newInstance() {
        return new MyFragment();
    }
}
