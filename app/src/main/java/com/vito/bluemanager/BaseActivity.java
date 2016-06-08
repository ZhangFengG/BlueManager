package com.vito.bluemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/8.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/8 14:47
 * @ModifiedNotes:
 * @Version
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //移除标题栏，使用toolbar
    }
}
