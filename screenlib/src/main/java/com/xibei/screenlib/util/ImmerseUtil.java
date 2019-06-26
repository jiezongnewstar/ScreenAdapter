package com.xibei.screenlib.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewFragment;

/**
 * Created by Xibei on 2019/6/25.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 沉浸式
 */
public class ImmerseUtil {

    private static ImmerseUtil instance;

    private Context context;

    private ImmerseUtil(Context context){
        this.context = context;
    }

    public static ImmerseUtil getInstance(Context context){
        synchronized (ImmerseUtil.class){
            if (instance ==null){
                instance = new ImmerseUtil(context);
            }
        }

        return instance;
    }


    /**
     *
     * 沉浸式标题栏，最主要的就是版本兼容的问题。 分水岭 android 4.4   android 5.0
     *
     */

    public ImmerseUtil setImmerse(){

        //如果安卓版本小于 4.4
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            return new ImmerseUtil(context);
        }

        //5.0以后
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //获取window对象
            Window window = ((Activity)context).getWindow();
            //清空window标记
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加绘制状态栏的标记
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色透明
            window.setStatusBarColor(Color.TRANSPARENT);
            //对窗口属性设置
            int visibility = window.getDecorView().getSystemUiVisibility();
            //全屏
            visibility |= View.SYSTEM_UI_FLAG_FULLSCREEN;
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            //防止内容区域大小发生变化
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            //隐藏虚拟按键导航栏
//            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

            window.getDecorView().setSystemUiVisibility(visibility);

            //5.0之前
        }else {
            ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        return instance;
    }


    // 获取状态栏高度
    public int getStatusBarHeight(){
        int resID = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resID > 0){
            return context.getResources().getDimensionPixelOffset(resID);
        }
        return 96;
    }


    //设置toolbar padding   //这里注意，要给toolbar设置高度，否则不生效
    public void setToolbarPadding(View view){
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height += getStatusBarHeight();
        view.setPadding(view.getPaddingLeft(),view.getPaddingTop() + getStatusBarHeight(),
                view.getPaddingRight(),view.getPaddingBottom());
    }



}
