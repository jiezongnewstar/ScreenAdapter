package com.xibei.screenlib.pixel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 根据设计稿比例进行相对适配
 */
public class PixelAdaptRelativeLayout extends RelativeLayout {
    public PixelAdaptRelativeLayout(Context context) {
        this(context,null);
    }

    public PixelAdaptRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PixelAdaptRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
