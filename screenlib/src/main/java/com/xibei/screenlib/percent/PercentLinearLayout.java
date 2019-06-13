package com.xibei.screenlib.percent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 百分比线性布局
 */
public class PercentLinearLayout extends LinearLayout {

    public PercentLinearLayout(Context context) {
        this(context,null);
    }

    public PercentLinearLayout(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PercentLinearLayout(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
