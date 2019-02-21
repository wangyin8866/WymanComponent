package com.wyman.library_common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 *
 * 只会显示一个toast
 * 不会有延迟的toast
 *
 * @author pengjun
 */
public class ToastAlone extends Toast {
    Context context;
    /**
     * 唯一的toast
     */
    private static Toast mToast = null;



    public ToastAlone(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * 显示的可以及时清除
     *
     * @param ctx
     * @param tips
     * @param lastTime
     * @return
     */
    public static Toast showToast(Context ctx, String tips, int lastTime) {
        if (tips != null && tips.length() > 0) {
            if (mToast != null) {
                mToast.setText(tips);
//			mToast.cancel();
            } else {
                if (ctx != null) {
                    mToast = Toast.makeText(ctx, tips, lastTime);
                }
            }
            if (mToast != null) {
                mToast.show();
            }
        }
        return mToast;
    }

    public static Toast showShortToast(Context ctx, String tips) {
        if (tips != null && tips.length() > 0) {
            if (mToast != null) {
                mToast.setText(tips);
//			mToast.cancel();
            } else {
                if (ctx != null) {
                    mToast = Toast.makeText(ctx, tips, Toast.LENGTH_SHORT);
                }
            }
            if (mToast != null) {
                mToast.show();
            }
        }
        return mToast;
    }

    public static Toast showLongToast(Context ctx, String tips) {
        if (tips != null && tips.length() > 0) {
            if (mToast != null) {
//			mToast.cancel();
                mToast.setText(tips);
            } else {
                if (ctx != null) {
                    mToast = Toast.makeText(ctx, tips, Toast.LENGTH_LONG);
                }
            }
            if (mToast != null) {
                mToast.show();
            }
        }
        return mToast;
    }


}
