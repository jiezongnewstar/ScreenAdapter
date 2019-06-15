package com.xibei.screenlib.density;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * Created by Xibei on 2019/6/14.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 修改系统density类
 */
public class Density {

    private static final float DEVICE_WIDTH = 1080;                //设计（参考）设备宽度 单位dp  例：320dp

    private static float appDensity;                              //屏幕密度
    private static float appScaleDensity;                         //字体缩放比例，默认appDensity


    public static void setDensity(final Application application, Activity activity){
        //获取默认屏幕信息
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        if (appDensity == 0){
            //赋值
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;

            //添加系统字体变化监听回调
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体发生更改，重新对scaleDensity赋值
                    if (newConfig != null && newConfig.fontScale > 0){
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        //计算目标值density、scaleDensity、densitDpi
        //例： 如果目标设备屏幕宽度为1080 那么 targetDensity = 1080 / 360 = 3.0
        float targetDensity = displayMetrics.widthPixels / DEVICE_WIDTH;
        float targetScaleDensity = targetDensity * (appScaleDensity / appScaleDensity);
        int targetDensityDpi = (int) (targetDensity * 160);

        //替换app Activity 的 density 、scaleDensity 、 densityDpi
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        metrics.density = targetDensity;
        metrics.scaledDensity = targetScaleDensity;
        metrics.densityDpi = targetDensityDpi;
    }

}
