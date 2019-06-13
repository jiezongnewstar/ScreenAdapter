package com.xibei.screenlib.percent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration:  百分比帧布局
 */
public class PercentFrameLayout extends FrameLayout {

    public PercentFrameLayout(Context context) {
        this(context,null);
    }

    public PercentFrameLayout( Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PercentFrameLayout( Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
