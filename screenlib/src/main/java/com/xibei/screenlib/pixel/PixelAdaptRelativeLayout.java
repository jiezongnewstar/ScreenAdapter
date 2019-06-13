package com.xibei.screenlib.pixel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.xibei.screenlib.util.ScaleHelper;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 根据设计稿比例进行相对适配
 */
public class PixelAdaptRelativeLayout extends RelativeLayout {

    //防止二次测量
    private boolean mesured = false;

    public PixelAdaptRelativeLayout(Context context) {
        this(context,null);
    }

    public PixelAdaptRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PixelAdaptRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (!mesured){
            //得到缩放因子
            float scaleX = ScaleHelper.getInstance(getContext(),false).getScaleX();
            float scaleY = ScaleHelper.getInstance(getContext(),false).getScaleY();

            //得到子控件
            int childCount = getChildCount();
            //遍历子控件换算最终缩放值
            for (int i = 0; i < childCount; i++) {
                View child  = getChildAt(i);
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                params.width = (int) (params.width * scaleX);
                params.height = (int) (params.height * scaleY);
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
