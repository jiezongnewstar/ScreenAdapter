package com.xibei.screenadapter;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration: 适配展示页
 */
public class SimpleActivity extends Activity {

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

    }
}
