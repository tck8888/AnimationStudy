package com.tck.animationstudy;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class PageModel {

    Fragment mFragment;
    @StringRes
    int titleRes;

    PageModel(Fragment fragment, @StringRes int titleRes) {
        mFragment = fragment;
        this.titleRes = titleRes;

    }
}
