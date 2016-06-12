package com.vito.bluemanager.editmessage;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vito.bluemanager.BaseActivity;
import com.vito.bluemanager.R;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/8.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/8 11:15
 * @ModifiedNotes:
 * @Version
 */
public class EditMessageActivity extends BaseActivity{

    private final static String EDIT_MSG_TAG = "EDIT_MSG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editmessage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        EditMessageFragment editFragment = (EditMessageFragment) fragmentManager.findFragmentById(R.id.content_fragment);
        if(editFragment==null){
            editFragment = new EditMessageFragment();
            fragmentManager.beginTransaction().add(R.id.content_fragment, editFragment, EDIT_MSG_TAG).commit();
        }

        new EditMessagePersenter(editFragment);

    }



}
