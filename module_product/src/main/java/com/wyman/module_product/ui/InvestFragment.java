package com.wyman.module_product.ui;

import android.support.annotation.Keep;
import android.view.View;

import com.wyman.library_common.base.BaseFragment;
import com.wyman.library_common.base.BasePresenter;
import com.wyman.module_product.R;


/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */
@Keep
public class InvestFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_invest_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }



    public static InvestFragment newInstance() {
        return new InvestFragment();
    }
}
