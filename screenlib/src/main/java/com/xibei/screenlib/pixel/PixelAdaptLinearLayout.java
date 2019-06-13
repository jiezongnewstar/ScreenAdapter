package com.xibei.screenlib.pixel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 根据设计稿比例进行线性适配
 */
public class PixelAdaptLinearLayout extends LinearLayout {
    public PixelAdaptLinearLayout(Context context) {
        this(context,null);
    }

    public PixelAdaptLinearLayout(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PixelAdaptLinearLayout(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
