package com.tck.animationstudy;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class DpUtils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
