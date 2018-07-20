package com.wyman.module_home.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wyman.library_common.base.BaseFragment;
import com.wyman.library_common.base.BaseView;
import com.wyman.library_common.utils.LogUtils;
import com.wyman.module_home.R;
import com.wyman.module_home.R2;
import com.wyman.module_home.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author wyman
 * @date 2018/4/13
 * description : 测试悬浮窗
 */

public class HomeFragment extends BaseFragment<HomePresenter,BaseView>{


    @BindView(R2.id.text)
    TextView text;
    Unbinder unbinder;
    @BindView(R2.id.home_btn_test)
    Button homeBtnTest;

    @Override
    protected void initView(View view) {


    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        LogUtils.e("onSupportVisible","onSupportVisible");
        mPresenter.fetch();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(mContext);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R2.id.home_btn_test)
    public void onViewClicked() {
        ARouter.getInstance().build("/account/ARouterTestActivity").withString("name","wyman").navigation();
    }

    @Override
    public void showSuccess(String message) {
        super.showSuccess(message);

    }
}
