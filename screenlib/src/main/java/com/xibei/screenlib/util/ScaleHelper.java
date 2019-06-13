package com.xibei.screenlib.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 屏幕缩放因子帮助类
 */
public class ScaleHelper {

    //设计稿宽高
    private static final float UI_WIDTH = 720;
    private static final float UI_HEIGHT = 1280;

    //手机宽高
    private int mDisplayWidth;
    private int mDisplayHeight;


    private static ScaleHelper instance;



    public static ScaleHelper getInstance(Context context,boolean containStatusBar) {

        if (instance == null){

            instance = new ScaleHelper(context.getApplicationContext(),containStatusBar);
        }

        return instance;
    }


    private ScaleHelper(Context context,boolean containStatusBar){

       //获取屏幕宽高
        if (mDisplayWidth == 0 || mDisplayHeight == 0){
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (manager != null){
                DisplayMetrics displayMetrics = new DisplayMetrics();
                manager.getDefaultDisplay().getMetrics(displayMetrics);
                if (displayMetrics.widthPixels > displayMetrics.heightPixels){  //横屏
                    mDisplayWidth = displayMetrics.heightPixels;
                    if (containStatusBar){
                        mDisplayHeight = displayMetrics.widthPixels - getStatusBarHeight(context);
                    }else {
                        mDisplayHeight = displayMetrics.widthPixels;
                    }

                }else {
                    mDisplayWidth = displayMetrics.widthPixels;
                    if (containStatusBar){
                        mDisplayHeight = displayMetrics.heightPixels - getStatusBarHeight(context);
                    }else {
                        mDisplayHeight = displayMetrics.heightPixels;
                    }

                }
            }
        }

    }



    private int getStatusBarHeight(Context context) {
        int resID = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resID > 0){
            return context.getResources().getDimensionPixelSize(resID);
        }
        return 0;
    }



    //水平缩放比例
    public float getScaleX(){
        return mDisplayWidth / UI_WIDTH;
    }


    //获取垂直缩放比例
    public float getScaleY(){
        return mDisplayHeight / UI_HEIGHT;
    }


}
