package com.xibei.screenadapter;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Xibei on 2019/6/13.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration:
 */
public class SimpleActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.pixel_relativelayout);
        setContentView(R.layout.pixel_linearlaytout);
//        setContentView(R.layout.pixel_framelaytout);


    }
}
