package com.wyman.module_main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.wyman.library_common.base.BaseActivity;
import com.wyman.library_common.base.BasePresenter;
import com.wyman.library_common.base.ClassUtils;
import com.wyman.library_common.base.IViewDelegate;
import com.wyman.library_common.utils.ToastAlone;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @BindView(R2.id.id_tab_iv_01)
    ImageView idTabIv01;
    @BindView(R2.id.id_tab_tv_01)
    TextView idTabTv01;
    @BindView(R2.id.id_tab_ll_01)
    LinearLayout idTabLl01;
    @BindView(R2.id.id_tab_iv_02)
    ImageView idTabIv02;
    @BindView(R2.id.id_tab_tv_02)
    TextView idTabTv02;
    @BindView(R2.id.id_tab_ll_02)
    LinearLayout idTabLl02;
    @BindView(R2.id.id_tab_iv_03)
    ImageView idTabIv03;
    @BindView(R2.id.id_tab_tv_03)
    TextView idTabTv03;
    @BindView(R2.id.id_tab_ll_03)
    LinearLayout idTabLl03;
    @BindView(R2.id.id_tab_iv_04)
    ImageView idTabIv04;
    @BindView(R2.id.id_tab_tv_04)
    TextView idTabTv04;
    @BindView(R2.id.id_tab_ll_04)
    LinearLayout idTabLl04;
    private long mExitTime;
    public static int currentPage;
    private List<ISupportFragment> mFragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected void initView() {
        mFragments = new ArrayList<>();
        ISupportFragment homeFragment = findFragment(getHomeFragment().getClass());

        if (homeFragment == null) {
            mFragments.add(0, getHomeFragment());
            mFragments.add(1, getProductFragment());
            mFragments.add(2, getAccountFragment());
            mFragments.add(3, getHomeFragment());
            loadMultipleRootFragment(R.id.layout_fragment, currentPage,
                    mFragments.get(0),
                    mFragments.get(1),
                    mFragments.get(2),
                    mFragments.get(3)
            );

        } else {
            // 这里我们需要拿到mFragments的引用
            mFragments.add(0, homeFragment);
            mFragments.add(1, findFragment(getProductFragment().getClass()));
            mFragments.add(2, findFragment(getAccountFragment().getClass()));
            mFragments.add(3, homeFragment);
        }
        setTabSelection(currentPage);

    }

    public void setTabSelection(int currentPage) {
        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0://未登录
                idTabIv01.setImageResource(R.mipmap.ic_home_checked);
                idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 1:
                idTabIv02.setImageResource(R.mipmap.ic_product_checked);
                idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 2:
                idTabIv03.setImageResource(R.mipmap.ic_baina_checked);
                idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 3:
                idTabIv04.setImageResource(R.mipmap.ic_my_checked);
                idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
        }
    }

    /**
     * 重置所有状态
     */
    private void restView() {
        idTabIv01.setImageResource(R.mipmap.ic_home);
        idTabIv02.setImageResource(R.mipmap.ic_product);
        idTabIv03.setImageResource(R.mipmap.ic_baina);
        idTabIv04.setImageResource(R.mipmap.ic_my);
        idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastAlone.showShortToast(mContext, "再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 在News模块中寻找实现的Fragment
     *
     * @return Fragment
     */
    private ISupportFragment getHomeFragment() {
        ISupportFragment homeFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wyman.module_home.ui");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            homeFragment = viewDelegates.get(0).getFragment("");
        }
        return homeFragment;
    }

    private ISupportFragment getProductFragment() {
        ISupportFragment productFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wyman.module_product.ui");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            productFragment = viewDelegates.get(0).getFragment("");
        }
        return productFragment;
    }

    private ISupportFragment getAccountFragment() {
        ISupportFragment accountFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wyman.module_account.ui");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            accountFragment = viewDelegates.get(0).getFragment("");
        }
        return accountFragment;
    }

    @OnClick({R2.id.id_tab_ll_01, R2.id.id_tab_ll_02, R2.id.id_tab_ll_03, R2.id.id_tab_ll_04})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.id_tab_ll_01) {
            ToastUtils.showShort("aaa");
            showHideFragment(mFragments.get(0), mFragments.get(currentPage));
            currentPage = 0;
            setTabSelection(currentPage);
        } else if (i == R.id.id_tab_ll_02) {
            showHideFragment(mFragments.get(1), mFragments.get(currentPage));
            currentPage = 1;
            setTabSelection(currentPage);
        } else if (i == R.id.id_tab_ll_03) {
            showHideFragment(mFragments.get(2), mFragments.get(currentPage));
            currentPage = 2;
            setTabSelection(currentPage);
        } else if (i == R.id.id_tab_ll_04) {
            showHideFragment(mFragments.get(3), mFragments.get(currentPage));
            currentPage = 3;
            setTabSelection(currentPage);
        }
    }
}
