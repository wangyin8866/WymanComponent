package com.wyman.library_common.net;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;

import com.wyman.library_common.R;


/**
 * 自定义retrofit加载框
 * Created by NIUDEYANG on 2016/11/18.
 */

public class CustomProgressDialog extends Dialog {

    private AnimationDrawable mAnimationDrawable;
    private static CustomProgressDialog mCustomProgressDialog = null;
    private static Context mContext;

    public CustomProgressDialog(Context context) {
        this(context, R.style.CustomProgressDialog);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_custom_loading);
        getWindow().getAttributes().gravity = Gravity.CENTER;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ImageView imageView = (ImageView) findViewById(R.id.iv_progress);
//        imageView.setImageResource(R.drawable.anim_loading);
        imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.anim_loading));
        mAnimationDrawable = (AnimationDrawable) imageView.getDrawable();
        mAnimationDrawable.start();
    }

    public static CustomProgressDialog createDialog(Context context) {
        mContext = context;
        mCustomProgressDialog = new CustomProgressDialog(context);
        mCustomProgressDialog.setCanceledOnTouchOutside(false);
        return mCustomProgressDialog;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (null != mAnimationDrawable) {
            mAnimationDrawable.stop();
        }
        mAnimationDrawable = null;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mContext != null && mContext instanceof Activity) {
            if (mCustomProgressDialog != null && !((Activity) mContext).isFinishing()) {
                mCustomProgressDialog.dismiss();
            }
        }
        mCustomProgressDialog = null;
        if (null != mAnimationDrawable) {
            mAnimationDrawable.stop();
        }
        mAnimationDrawable = null;
    }
}
