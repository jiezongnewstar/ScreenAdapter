package com.xibei.screenadapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.xibei.screenlib.density.Density;


/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 适配展示页
 */
public class SimpleActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /**
        * 自定义像素布局适配
        */
//        setContentView(R.layout.pixel_relativelayout);
//        setContentView(R.layout.pixel_linearlaytout);
//        setContentView(R.layout.pixel_framelaytout);

        /**
         * 自定义百分比布局适配
         */

//        setContentView(R.layout.percent_relativelayout);
//        setContentView(R.layout.percent_linearlayout);
//        setContentView(R.layout.percent_framelayout);

        /**
         * 修改系统density scaleDensity densityDpi 适配
         */

        //这里设置density的方法有两种，在BaseActivity中设置，或者在Application中设置（见App.java）
//        Density.setDensity(getApplication(),this);
//        setContentView(R.layout.activity_simple);

        /**
         * 刘海屏适配 1、设置全屏 2、判断手机是否有刘海 3、让内容区延伸进入状态栏 4、设置沉浸式
         */

        //将界面设置成全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //判断厂商
        //9.0判断是否有刘海
        boolean hasDisplyCutout = hasDisplyCutout(window);
        if (hasDisplyCutout){

            //设置刘海策略
            WindowManager.LayoutParams params = window.getAttributes();
            params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(params);

            //设置沉浸式布局
            int flags = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

            int visbility = window.getDecorView().getSystemUiVisibility();
            visbility |=flags;
            window.getDecorView().setSystemUiVisibility(visbility);

        }


        setContentView(R.layout.cutout_layout);

        //获取刘海高度，判断是否避开刘海区
        if (hasDisplyCutout){
            RelativeLayout rl_title = findViewById(R.id.rl_title);
            rl_title.setPadding(rl_title.getPaddingLeft(),
                    getDisplayCutoutHeight(),
                    rl_title.getPaddingRight(),
                    rl_title.getPaddingBottom());
        }


    }

    @TargetApi(Build.VERSION_CODES.P)
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean hasDisplyCutout(Window window) {
        DisplayCutout displayCutout;
        View rootView = window.getDecorView();
        WindowInsets windowInsets = rootView.getRootWindowInsets();
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && windowInsets != null ){
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null){
                if (displayCutout.getBoundingRects() != null
                && displayCutout.getBoundingRects().size() > 0
                && displayCutout.getSafeInsetTop() > 0){
                    return  true;
                }
            }
        }

        return true;  //模拟器会返回false 为了调试，强行设置成true
    }


    //获取刘海高度
    public int getDisplayCutoutHeight(){

        int resID = getResources().getIdentifier("status_bar_height","dimen","android");

        if (resID > 0){
            return getResources().getDimensionPixelOffset(resID);
        }

        return 96;   //通常情况下，刘海高度就是状态栏高度96
    }

}
