package com.vito.bluemanager.contacts;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vito.bluemanager.R;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 10:55
 * @ModifiedNotes:
 * @Version
 */
public class ContactsActivity extends AppCompatActivity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        init();

    }

    private void init() {
        FragmentManager fragmentManager = getFragmentManager();
        ContactsFragment contactsFragment = (ContactsFragment) fragmentManager.findFragmentById(R.id.content_fragment);
        if(contactsFragment==null){
            contactsFragment = new ContactsFragment();
            fragmentManager.beginTransaction().add(R.id.content_fragment, contactsFragment).commit();
        }
        ContactsPersenter contactsPersenter = new ContactsPersenter(contactsFragment);
    }

}
