package com.wyman.module_account.ui;

import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wyman.library_common.base.BaseActivity;
import com.wyman.library_common.base.BasePresenter;
import com.wyman.library_common.utils.LogUtils;
import com.wyman.module_account.R;
import com.wyman.module_account.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wyman
 * @date 2018/7/20
 * description :
 */
@Route(path = "/account/ARouterTestActivity")
public class ARouterTestActivity extends BaseActivity {
    @BindView(R2.id.btn_test)
    Button btnTest;
    @Autowired
    String name;
    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        LogUtils.e("name", name);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.account_aroutor_test;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @OnClick(R2.id.btn_test)
    public void onViewClicked() {
    }
}
