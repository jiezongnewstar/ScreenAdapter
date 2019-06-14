package com.xibei.screenlib.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xibei.screenlib.R;

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


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //获取父容器尺寸
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams params = child.getLayoutParams();
            //布局属性校验
            if (checkLayoutParams(params)){
                PercentParams percentParams = (PercentParams) params;
                float widthPercent = percentParams.widthPercent;
                float heightPercent = percentParams.heightPercent;
                float marginLeftPercent = percentParams.marginLeftPercent;
                float marginRightPercent = percentParams.marginRightPercent;
                float marginTopPercent = percentParams.marginTopPercent;
                float marginBottomPercent = percentParams.marginBottomPercent;

                if (widthPercent > 0){
                    params.width = (int) (widthSize * widthPercent);
                }

                if (heightPercent > 0){
                    params.height = (int) (heightSize * heightPercent);
                }

                if (marginLeftPercent > 0){
                    ((PercentParams) params).leftMargin = (int) (widthSize * marginLeftPercent);
                }

                if (marginRightPercent > 0){
                    ((PercentParams) params).rightMargin = (int) (widthSize * marginRightPercent);
                }

                if (marginTopPercent > 0){
                    ((PercentParams) params).topMargin = (int) (heightSize * marginTopPercent);
                }

                if (marginBottomPercent > 0){
                    ((PercentParams) params).bottomMargin = (int) (heightSize * marginBottomPercent);
                }

            }

        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof PercentParams;
    }

    public PercentParams generateLayoutParams(AttributeSet attrs){
        return  new PercentParams(getContext(),attrs);
    }



    //构造自定义属性容器类
    public static class PercentParams extends LinearLayout.LayoutParams{

        //声明自定义属性
        private float widthPercent;
        private float heightPercent;
        private float marginLeftPercent;
        private float marginRightPercent;
        private float marginTopPercent;
        private float marginBottomPercent;


        public PercentParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            //解析自定义属性
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.PercentLayout);
            widthPercent = typedArray.getFloat(R.styleable.PercentLayout_widthPercent,0);
            heightPercent = typedArray.getFloat(R.styleable.PercentLayout_heightPercent,0);
            marginLeftPercent = typedArray.getFloat(R.styleable.PercentLayout_marginLeftPercent,0);
            marginRightPercent = typedArray.getFloat(R.styleable.PercentLayout_marginRightPercent,0);
            marginTopPercent = typedArray.getFloat(R.styleable.PercentLayout_marginTopPercent,0);
            marginBottomPercent = typedArray.getFloat(R.styleable.PercentLayout_marginBottomPercent,0);

            //回收
            typedArray.recycle();
        }
    }
}
