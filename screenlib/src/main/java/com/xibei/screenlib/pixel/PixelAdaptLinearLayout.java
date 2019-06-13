package com.xibei.screenlib.pixel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.xibei.screenlib.util.ScaleHelper;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 根据设计稿比例进行线性适配
 */
public class PixelAdaptLinearLayout extends LinearLayout {

    //防止二次测量
    private boolean mesured = false;


    public PixelAdaptLinearLayout(Context context) {
        this(context,null);
    }

    public PixelAdaptLinearLayout(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PixelAdaptLinearLayout(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (!mesured){
            float scaleX = ScaleHelper.getInstance(getContext(),false).getScaleX();
            float scaleY = ScaleHelper.getInstance(getContext(),false).getScaleY();

            int childCount = getChildCount();

            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                params.height = (int) (params.height * scaleY);
                params.width = (int) (params.width * scaleX);
                params.leftMargin = (int) (params.leftMargin * scaleX);
                params.rightMargin = (int) (params.rightMargin * scaleX);
                params.topMargin = (int) (params.topMargin * scaleY);
                params.bottomMargin = (int) (params.bottomMargin * scaleY);
            }

            mesured = true;
        }


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
