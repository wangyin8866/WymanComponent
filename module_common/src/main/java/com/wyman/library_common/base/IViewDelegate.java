package com.wyman.library_common.base;


import android.support.annotation.Keep;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * <p>类说明</p>
 *
 * @name IFragmentDelegate
 */
@Keep
public interface IViewDelegate {

    ISupportFragment getFragment(String name);


}
